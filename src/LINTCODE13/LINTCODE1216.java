package LINTCODE13;

public class LINTCODE1216 {
    /*Description
    *找到由两个n位数字的乘积构成的最大回文数。
    * 由于结果可能非常大，您应该返回最大的回文数 mod 1337。
    * */

    /*Solution
    * 暴力解法
    * */

    public int largestPalindrome(int n) {
        if(n==1)
            return 9;
        long max= (long) (Math.pow(10,n)-1);
        long min= (long) Math.pow(10,n-1);
        long maxProduct=max*max;
        for(long i=max;i>=min;i--){
            long cur=getNumber(i);
            //System.out.println(cur);
            if(cur>maxProduct)
                continue;
            for(long j=max;j>=min;j--){
                if(cur/j>max)
                    break;
                if(cur%j==0)
                    return (int) (cur%1337);
            }
        }
        return -1;
        // write your code here
    }

    private long getNumber(long i){
        StringBuilder sb=new StringBuilder(String.valueOf(i));
        StringBuilder cur=new StringBuilder(String.valueOf(i)).append(sb.reverse());
        return Long.parseLong(cur.toString());
    }

}
