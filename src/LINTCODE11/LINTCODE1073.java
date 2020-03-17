package LINTCODE11;

import java.util.Arrays;
import java.util.List;

public class LINTCODE1073 {
    /*Description
    * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
    * */

    public int findLength(List<Integer> A, List<Integer> B) {
        int ALength=A.size();
        int BLength=B.size();
        int[][] dp=new int[BLength+1][ALength+1];
        int result=0;
        for(int i=0;i<BLength;i++){
            int cur=B.get(i);
            for(int j=0;j<ALength;j++){
                if(cur==A.get(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    result=Math.max(result,dp[i+1][j+1]);
                }
            }
        }
        return result;
        // write your code here
    }
}
