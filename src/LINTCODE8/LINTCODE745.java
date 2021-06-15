package LINTCODE8;

public class LINTCODE745 {
    /*Description
    * 如果一个正整数的十进制表示(没有前导零)是一个回文字符串(一个前后读取相同的字符串)，那么它就是回文。
    * 例如，数字5, 77, 363, 4884, 11111, 12121和349943都是回文。
    * 如果一个整数范围包含偶数个回文，那么它就是一个有趣的范围。范围 [L, R]且L <= R的定义为从L到R(包括):
    * (L, L+1, L+2，……，R-1, R)的整数序列。L和R是这个范围的第一个和最后一个数字。
    * 如果L <= L1 <= R1 <= R1 > = R，那么范围[L1, R1]就是[L, R]的子集合。你的工作是确定有多少有趣的[L, R]子集。
    * */
    public int PalindromicRanges(int L, int R) {
        int[] dp=new int[R-L+2];
        int even=0;
        int odd=0;
        for(int i=L;i<=R;i++){
            dp[i-L+1]=dp[i-L];
            if(isPal(i))
                dp[i-L+1]++;
            if(dp[i-L+1]%2==0)
                odd++;
            else
                even++;
        }
        int result=0;
        for(int i=1;i<dp.length;i++){
            if(dp[i-1]%2==0) {
                result+=odd;
            }else{
                result+=even;
            }
            if(dp[i]%2==0)
                odd--;
            else
                even--;
        }
        return result;
        // test
    }

    private boolean isPal(int cur){
        int num=cur;
        int pal=0;
        while(num>0){
            pal=pal*10+num%10;
            num/=10;
        }
        return pal==cur;

    }
}
