package LINTCODE11;

public class LINTCODE1028 {
    /*Description
    *X是一个好数当且仅当单独旋转每一个数位180度之后，能够得到一个合法的不同于X的数。每一个数位必须被旋转 - 我们不能选择不管它。
    * 如果每一个数位在旋转之后仍然是一个数位，那么这个数字是合法的。0,1和8旋转保持不变;
    * 2和5旋转后互相变换; 6和9旋转后互相变换，其余数字旋转后不会变成任何数字所以是不合法的。
    * 现在给定一个正数 N，多少1 到 N 之间的数X是好的?
    * */

    public int rotatedDigits(int N) {
        if(N<=1)
            return 0;
        if(N<5)
            return 1;
        if(N<6)
            return 2;
        if(N<9)
            return 3;
        if(N<=10)
            return 4;
        int[] dp=new int[N+1];
        int result=4;
        int[] flag1=new int[]{0,1,8};
        int[] flag2=new int[]{2,5,6,9};
        for(int cur:flag1)
            dp[cur]=1;
        for(int cur:flag2)
            dp[cur]=2;
        for(int i=10;i<=N;i++){
            int index1=i/10;
            int index2=i%10;
            if(dp[index1]==0||dp[index2]==0)
                continue;
            if(dp[index1]==2||dp[index2]==2){
                dp[i]=2;
                result++;
            }else
                dp[i]=1;
        }
        return result;
        // write your code here
    }
}
