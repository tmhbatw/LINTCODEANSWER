package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1098 {
    /*Description
    * 如果树的深度小于5，则该树可以由三位整数的列表表示。
    * 对于此列表中的每个整数：
    * 百位数表示该节点的深度D，1 <= D <= 4。
    * 2.十位数表示该节点在其所属级别中的位置P，1 <= P <= 8.该位置与完整二叉树中的位置相同。
    * 3.单位数字表示该节点的值V，0 <= V <= 9。
    * 给定一个表示深度小于5的二叉树的升序三位整数列表，您需要返回从根到叶子的所有路径和的总和。
    * */

    public int pathSumIV(int[] nums) {
        int[][] dp=new int[5][9];
        for(int[] cur:dp)
            Arrays.fill(cur,-1);
        for(int cur:nums){
            int val=cur%10;
            cur/=10;
            int col=cur%10;
            cur/=10;
            int row=cur;
            dp[row][col]=val;
        }
        int result=0;
        for(int i=1;i<5;i++){
            for(int j=0;j<9;j++){
                if(dp[i][j]!=-1){
                    if(i==4||dp[i+1][j*2]==-1&&dp[i+1][j*2-1]==-1) {
                        result += dp[i][j];
                        continue;
                    }
                    if(dp[i+1][j*2]!=-1){
                        dp[i+1][j*2]+=dp[i][j];
                    }
                    if(dp[i+1][j*2-1]!=-1){
                        dp[i+1][j*2-1]+=dp[i][j];
                    }
                }
            }
        }
        return result;
        // Write your code here.
    }
}
