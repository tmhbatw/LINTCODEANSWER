package LINTCODE14;

public class LINTCODE1324 {
    /*Description
    * 计算小于非负数n的质数的个数。
    * */

    public int countPrimes(int n) {
        if(n<=2)
            return 0;
        boolean[] dp=new boolean[n];
        int result=0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(!dp[i]){
                result++;
                int cur=i*2;
                while(cur<n){
                    dp[cur]=true;
                    cur+=i;
                }
            }
        }
        for(int i=(int)Math.sqrt(n)+1;i<n;i++)
            if(!dp[i])
                result++;
        return result;
        // write your code here
    }
}
