package LINTCODE10;

public class LINTCODE992 {
    /*Description
    * 给两个整数 n 和 k，你需要构造一个包含 n 个不同正整数的列表，范围从 1 到 n 并遵守以下要求：
    * 假设这个列表是[a1，a2，a3，...，an]，并且列表[| a1 - a2 |，| a2 - a3 |，
    * | a3 - a4 |，...，| an-1 - an |]恰好具有 k 个不同的整数。
    * 如果有多个答案，返回任意一个即可。
    * */

    public int[] constructArray(int n, int k) {
        int[] res=new int[n];
        for(int i=0;i<n-k;i++){
            res[i]=i+1;
        }
        boolean isBig=true;
        for(int i=n-k;i<n;i++){
            if(isBig)
                res[i]=n-(i-n+k)/2;
            else
                res[i]=n-k+(i-n+k+1)/2;
            isBig=!isBig;
        }
        return res;
        // Write your code here
    }
}
