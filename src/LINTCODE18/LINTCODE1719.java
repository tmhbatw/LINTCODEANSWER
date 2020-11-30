package LINTCODE18;

public class LINTCODE1719 {
    /*Description
    * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
    * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
    * */

    public int threeSumMulti(int[] A, int target) {
        int mod=1000000007;
        long result=0;
        int[] dp=new int[301];
        for(int cur:A)
            dp[cur]++;
        for(int i=0;i<=100;i++){
            if(target==i*3){
                result+=(long)dp[i]*(dp[i]-1)*(dp[i]-2)/6;
                result%=mod;
                return (int)result;
            }
            if(i*3>target)
                return (int)result;
            result+=(long)dp[(target-i*2)]*dp[i]*(dp[i]-1)/2;
            result%=mod;
            for(int j=i+1;j<=100;j++){
                if(target-i-j<j)
                    break;
                if(target-i-j==j){
                    result+=(long)dp[i]*dp[j]*(dp[j]-1)/2;
                    result%=mod;
                    break;
                }
                result+=(long)dp[i]*dp[j]*dp[target-i-j];
                result%=mod;
            }
        }
        return (int)result;
        // Write your code here
    }

    public static void main(String[] args){
        System.out.println((long)3000*3000*3000);
    }

}
