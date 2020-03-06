package LINTCODE15;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1410 {
    /*Description
    * 给一个二维矩阵，每个grid的值代表地势的高度。水流只会沿上下左右流动，
    * 且必须从地势高的地方流向地势低的地方。视为矩阵四面环水，现在从(R,C)处注水，问水能否流到矩阵外面去？
    * */

        public String waterInjection(int[][] matrix, int R, int C) {
            Queue<int[]> queue=new LinkedList<>();
            queue.add(new int[]{R,C});
            int row=matrix.length;
            int col=matrix[0].length;
            int[][] near=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
            while(!queue.isEmpty()){
                int[] cur=queue.poll();
                int i=cur[0];
                int j=cur[1];
                System.out.println(i+" "+j);
                int height=matrix[i][j];
                if(i==0||j==col-1||i==row-1||j==0)
                    return "YES";
                for(int[] curNear:near){
                    int ii=i+curNear[0];
                    int jj=j+curNear[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col){
                        if(matrix[ii][jj]<height)
                            queue.add(new int[]{ii,jj});
                    }
                }
            }
            return "NO";
            // Write your code here
        }


}
