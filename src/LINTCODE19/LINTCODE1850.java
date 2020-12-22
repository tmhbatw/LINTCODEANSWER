package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1850 {
    /*Description
    * Alice 和 Bob 在一个漂亮的果园里面工作，果园里面有N棵苹果树排成了一排，这些苹果树被标记成1 - N号。
    * Alice 计划收集连续的K棵苹果树上面的所有苹果，Bob计划收集连续的L棵苹果树上面的所有苹果。
    * Alice和Bob选择的区间不可以重合，你需要返回他们能够最大收集的苹果数量。
    * */

    public int PickApples(int[] A, int K, int L) {
        int length=A.length;
        int[] dp=new int[length+1];
        for(int i=0;i<length;i++){
            dp[i+1]=dp[i]+A[i];
        }
        int result=-1;
        for(int i=0;i<length-K-L+1;i++){
            int cur=dp[K+i]-dp[i];
            for(int j=K+i;j<length-L+1;j++){
                result=Math.max(result,cur+dp[j+L]-dp[j]);
            }
        }
        for(int i=0;i<length-K-L+1;i++){
            int cur=dp[i+L]-dp[i];
            for(int j=i+L;j<length-K+1;j++){
                result=Math.max(result,cur+dp[j+K]-dp[j]);
            }
        }
        return result;
        // write your code here
    }

}
