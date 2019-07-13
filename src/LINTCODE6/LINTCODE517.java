package LINTCODE6;

public class LINTCODE517 {
    /*Description
    * 写一个程序来检测一个整数是不是丑数。
    * */

    /*Solution
    *将所有2、3、5因子全部除尽以后判断剩下的数字是否等于1
    * */

    public boolean isUgly(int num) {
        while(num%2==0)
            num/=2;
        while(num%3==0)
            num/=3;
        while(num%5==0)
            num/=5;
        return num==1;
        // write your code here
    }
}
