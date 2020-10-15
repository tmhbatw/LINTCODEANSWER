package LINTCODE2;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE199 {
    /*Description
    * 给定二维整数数组arr以及整数k，确定是否arr中值为k的所有单元是否都连接在一起。
    * 如果矩阵中的两个单元在水平或垂直方向上相邻且具有相同的值，则视为连接。
    * */

    public boolean judgeConnection(int[][] arr, int k) {
        int row=arr.length, col=arr[0].length;
        int[][] nextPos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==k){
                    arr[i][j]--;
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] cur=queue.poll();
                        for(int[] curr:nextPos){
                            int ii=cur[0]+curr[0];
                            int jj=cur[1]+curr[1];
                            if(ii>=0&&ii<row&&jj>=0&&jj<col&&arr[ii][jj]==k){
                                arr[ii][jj]--;
                                queue.add(new int[]{ii,jj});
                            }
                        }
                    }
                    return isTrue(arr,k);
                }
            }
        }
        return true;
        // Write your code here.
    }


    private boolean isTrue(int[][] arr, int k){
        int row=arr.length, col=arr[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==k)
                    return false;
            }
        }
        return true;
    }
}
