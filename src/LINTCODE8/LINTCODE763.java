package LINTCODE8;

public class LINTCODE763 {
    /*Description
    * 给定一个十进制数 n 和 一个整数 k, 将 十进制数 n 转换成 k进制数.
    * */

    char[] result=new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    public String hexConversion(int n, int k) {
        String res="";
        while(n!=0){
            int cur=n%k;
            res=result[cur]+res;
            n/=k;
        }
        return res.length()==0?"0":res;
        // write your code here
    }
}
