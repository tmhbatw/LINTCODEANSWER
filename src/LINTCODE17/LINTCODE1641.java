package LINTCODE17;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1641 {

    /*Description
    * 给一个 m * n 的矩阵, 里面的值是0 或者1. 如果一个点是 1 并且该点所在行或列中还有其他的 1, 那么我们可以把这个点变成 0. 请问最多可以把多少个 1 变成 0 ?
    * */

    public int getAns(int[][] mp) {
        int m=mp.length;
        int n=mp[0].length;
        int[] dp=new int[m*n]; //将一个二维矩阵以一维矩阵的方式存储起来，对应的转换方程为：row*m+col
        int pointNumber=0;
        for(int i=0;i<m;i++){
            int first=-1;
            int index=0;
            for(int j=0;j<n;j++){
                if(mp[i][j]==1){
                    pointNumber++;
                    if(first==-1){
                        dp[n*i+j]=n*i+j;
                        first=j;
                        index=n*i+first;
                    }else
                        dp[n*i+j]=index;
                }
            }
        }
        for(int j=0;j<n;j++){
            int first=-1;
            int index=0;
            for(int i=0;i<m;i++){
                if(mp[i][j]==1){
                    if(first==-1) {
                        first = i;
                        index=getType(dp,first*n+j);
                    }
                    else
                        dp[getType(dp,n*i+j)]=index;
                }
            }
        }
        Set<Integer> result=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mp[i][j]==1) {
                    result.add(getType(dp, i * n + j));
                    break;
                }
            }
        }
        return pointNumber-result.size();
        // Write your code here.
    }

    private int getType(int[] dp, int index){
        if(dp[index]!=index)
            return getType(dp,dp[index]);
        return index;
    }
}
