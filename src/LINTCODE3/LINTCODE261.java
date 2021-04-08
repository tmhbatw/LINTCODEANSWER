package LINTCODE3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE261 {

    /*Description
    * 有一个二维数组，数组中元素只有 0 和 1。
    * 你最多能将 1 个 0 变成 1，请求出由 1 组成的最大的连通块面积。
    * 如果在二维数组中有两个 1 上下或左右相邻，可以视作它们是连通的。
    * */


    /*Solution
    * 我想采用并查集的方法
    * */
        public int maxArea(int[][] matrix) {
            int row=matrix.length,col=matrix[0].length;
            int[] type=new int[row*col];
            int[] area=new int[row*col];
            for(int i=0;i<row*col;i++){
                type[i]=i;
            }
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(matrix[i][j]==1)
                        area[i*col+j]=1;
                }
            }
            for(int i=1;i<row;i++){
                if(matrix[i][0]==1&&matrix[i-1][0]==1){
                    int curType=getType(type,(i-1)*col);
                    type[i * col] = curType;
                    area[curType]++;
                }
            }
            for(int j=1;j<col;j++){
                if(matrix[0][j]==1&&matrix[0][j-1]==1){
                    int curType=getType(type,j-1);
                    type[j]=curType;
                    area[curType]++;
                }
            }
            for(int i=1;i<row;i++){
                for(int j=1;j<col;j++){
                    if(matrix[i][j]==1){
                        if(matrix[i-1][j]==1&&matrix[i][j-1]==1){
                            int type1=getType(type,(i-1)*col+j);
                            int type2=getType(type,(i)*col+j);
                            if(area[type1]>=area[type2]){
                                area[type1]+=area[type2]+1;
                                type[type2]=type1;
                                type[i*col+j]=type1;
                            }else{
                                area[type2]+=area[type1]+1;
                                type[type1]=type2;
                                type[i*col+j]=type2;
                            }
                        }else if(matrix[i-1][j]==1){
                            int type1=getType(type,(i-1)*col+j);
                            area[type1]++;
                            type[i*col+j]=type1;
                        }else if(matrix[i][j-1]==1){
                            int type1=getType(type,i*col+j-1);
                            area[type1]++;
                        }
                    }
                }
            }
            int result=Integer.MIN_VALUE;
            boolean fullOfOne=true;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(matrix[i][j]==0){
                        fullOfOne=false;
                        int curSum=1;
                        Set<Integer> set=new HashSet<>();
                        System.out.println(curSum);
                        if(i-1>=0){
                            int curType=getType(type,(i-1)*col+j);
                            if(!set.contains(curType)) {
                                curSum +=area[curType];

                                System.out.println("i-1,j is"+ area[curType]);
                                set.add(curType);

                            }
                        }
                        if(j-1>=0){
                            int curType=getType(type,i*col+j-1);
                            if(!set.contains(curType)){
                                curSum+=area[curType];
                                set.add(curType);

                                System.out.println("i,j-1 is"+ area[curType]);
                            }
                        }
                        if(i+1<row){
                            int curType=getType(type,(i+1)*col+j);
                            if(!set.contains(curType)){
                                curSum+=area[curType];
                                set.add(curType);

                                System.out.println("i+1,j is"+ area[curType]);
                            }
                        }
                        if(j+1<col){
                            int curType=getType(type,i*col+j+1);
                            if(!set.contains(curType)){
                                curSum+=area[curType];
                                set.add(curType);

                                System.out.println("i,j+1 is"+ area[curType]);
                            }
                        }
                        result=Math.max(result,curSum);
                    }
                }
            }
            System.out.println(Arrays.toString(type));

            System.out.println(Arrays.toString(area));
            if(fullOfOne)
                return row*col;
            return result;
            // write your code here.
        }

    private int getType(int[] type,int index){
        if(type[index]==index)
            return index;
        return getType(type,type[index]);
    }
}
