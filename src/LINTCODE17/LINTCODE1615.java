package LINTCODE17;

public class LINTCODE1615 {
    /*Description
    *给定一个列表funds表示投资人每次的投资额。现在有三个公司A, B, C,它们的初始资金分别为a,b,c。
    * 投资人每次投资时会对当前资金最少的公司进行投资（当有多个公司资金相同时，投资人会对编号最小的公司进行投资）。
    * 返回A, B, C三家公司最后的资金。
    * */

    public int[] getAns(int[] funds, int a, int b, int c) {
        for(int num:funds){
            if(a<=b&&a<=c)
                a+=num;
            else if(b<a&&b<=c)
                b+=num;
            else
                c+=num;
        }
        return new int[]{a,b,c};
        // Write your code here
    }
}
