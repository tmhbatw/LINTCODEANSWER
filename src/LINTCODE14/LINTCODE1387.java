package LINTCODE14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LINTCODE1387 {
    /*Description
    * 给定一个包含不同整数的数组，每一个整数一定大于1。
    * 用这些整数构造二叉树，每一个数可以被用多次。
    * 每一个非叶节点值等于所有子节点的积。
    * 这样的二叉树能构造多少？返回结果模10^9 + 7。
    * */

    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        int length=A.length;
        int mod=1000000007;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++)
            map.put(A[i],i);
        int[] dp=new int[length];
        for(int i=0;i<length;i++){
            long cur=1;
            for(int j=0;j<i;j++){
                if(A[i]%A[j]==0&&map.containsKey(A[i]/A[j])){
                    cur+= (long) dp[j] *dp[map.get(A[i]/A[j])];
                    cur%=mod;
                }
            }
            dp[i]=(int)cur;
        }
        int result=0;
        for(int cur:dp){
            result+=cur;
            result%=mod;
        }
        return result;
        //
    }
}
