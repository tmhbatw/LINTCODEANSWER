package LINTCODE12;

import java.util.Stack;

public class LINTCODE1136 {
    /*Description
    * 在一个二维矩阵上，每一个点都是一个 00 到 1010 之间的像素值，像素值都是整数。
    * 我们将大于像素阈值 pixelThreshold 的点称为高点击诱导点。
    * 由相连的高点击诱导点组成的区域的面积大于面积阈值 areaThreshold 的区域称为高点击诱导区域。
    * 如果两个点上下或左右相邻，则认为这两个点是相连的。
    * 请统计这个二维矩阵中高点击诱导区域的个数。
    * */

    public int highClickAreaCount(int[][] matrix, int pixelThreshold, int areaThreshold) {
        int row=matrix.length;
        int col=matrix[0].length;
        boolean[][] reached=new boolean[row][col];
        int[][] near=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!reached[i][j]&&matrix[i][j]>pixelThreshold){
                    reached[i][j]=true;
                    int curArea=1;
                    Stack<int[]> stack=new Stack<>();
                    stack.add(new int[]{i,j});
                    while(!stack.isEmpty()){
                        int[] curr=stack.pop();
                        for(int[] offset:near){
                            int ii=curr[0]+offset[0];
                            int jj=curr[1]+offset[1];
                            if(ii<row&&ii>=0&&jj<col&&jj>=0&&!reached[ii][jj]&&matrix[ii][jj]>pixelThreshold){
                                stack.add(new int[]{ii,jj});
                                curArea++;
                                reached[ii][jj]=true;
                            }
                        }
                    }
                    if(curArea>areaThreshold)
                        result++;
                }
            }
        }
        return result;
        // write your code here.
    }
}
