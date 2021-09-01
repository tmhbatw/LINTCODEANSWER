package LINTCODE10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE950 {
    /*Description
    * 给定3 x 3的矩阵，标号为1~9，其中8个方格内有数字，1~8，另有一个为空(用0表示)，
    * 问是否能将对应的数字放到对应标号的格子里(空格只能和上下左右位置交换),如果能输出"YES"，否则输出"NO"。
    * */

    Set<Integer> set=new HashSet<>();
    int target=123456780;

    public String  jigsawPuzzle(int[][] matrix) {
        Queue<int[][]> q=new LinkedList<>();
        q.add(matrix);
        while(!q.isEmpty()){
            int[][] cur=q.poll();
            int type=getType(cur);
            if(set.contains(type))
                continue;
            if(type==target){
                return "YES";
            }
            set.add(type);
            int x=0,y=0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(cur[i][j]==0){
                        x=i;
                        y=j;
                    }
                }
            }
            for(int[] next:nextPos){
                int i=x+next[0];
                int j=y+next[1];

                if(i>=0&&i<3&&j>=0&&j<3){
                    int[][] curr=new int[3][3];
                    for(int m=0;m<3;m++){
                        System.arraycopy(cur[m], 0, curr[m], 0, 3);
                    }

                    curr[x][y]=curr[i][j];
                    curr[i][j]=0;
                    q.add(curr);

                }
            }
        }
        return "NO";
        // Write your code here
    }

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};


    private int getType(int[][] matrix){
        int result=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                result*=10;
                result+=matrix[i][j];
            }
        }
        return result;
    }
}
