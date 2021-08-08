package LINTCODE3;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE258 {
    /*Description
    * 给定n×n的地图，每个单元都有一个高度，每次你只能够往相邻的单元格移动，
    * 并且要求这两个单元格的高度差不超过target。你不能走出地图之外。
    * 求出满足从左上角(0,0)走到右下右下角(n-1,n-1)最小的target。
    * */

    public int mapJump(int[][] arr) {
        int l=0,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(getRes(arr,mid))
                r=mid;
            else
                l=mid+1;
        }
        return l;
        // Write your code here.
    }

    private boolean getRes(int[][] arr, int mid){
        Queue<int[]> q=new LinkedList<>();
        int m=arr.length,n=arr[0].length;
        boolean[][] reached=new boolean[m][n];
        reached[0][0]=true;
        q.add(new int[]{0,0});
        int[][] nextPos=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] next:nextPos){
                int i=cur[0]+next[0];
                int j=cur[1]+next[1];
                if(i>=0&&i<m&&j>=0&&j<n&&!reached[i][j]&&Math.abs(arr[i][j]-arr[cur[0]][cur[1]])<=mid){
                    if(i==m-1&&j==n-1)
                        return true;
                    reached[i][j]=true;
                    q.add(new int[]{i,j});
                }
            }
        }
        return false;
    }
}
