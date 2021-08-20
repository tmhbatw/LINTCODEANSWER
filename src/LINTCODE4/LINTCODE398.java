package LINTCODE4;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LINTCODE398 {
    /*
    *
    * */

    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int m=matrix.length,n=matrix[0].length;
        int[][] res=new int[m][n];
        for(int[] cur:res)
            Arrays.fill(cur,-1);
        int result=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result=Math.max(result,fillRec(matrix,i,j,res));
            }
        }
        return result;
        // write your code here
    }

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    private int fillRec(int[][] matrix, int i,int j,int[][] res){
        if(res[i][j]!=-1)
            return res[i][j];
        int cur=0;
        for(int[] next:nextPos){
            int ii=next[0]+i,jj=next[1]+j;
            if(ii>=0&&ii<res.length&&jj>=0&&jj<res[0].length&&matrix[i][j]>matrix[ii][jj]){
                cur=Math.max(cur,fillRec(matrix,ii,jj,res));
            }
        }
        res[i][j]=cur+1;
        return res[i][j];
    }

}
