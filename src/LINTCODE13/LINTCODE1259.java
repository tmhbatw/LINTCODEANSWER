package LINTCODE13;

public class LINTCODE1259 {
    /*Description
    * 给定一个正整数n，你可以做如下的操作：
    * 如果n为偶数，将n替换为n/2
    * 如果n为奇数，你可以将n替换为n + 1或n - 1。
    * 将n转换为1的最少的替换次数为多少？
    * */

    public int integerReplacement(int n) {
        if(n==1)
            return 0;
        if(n%2==0)
            return integerReplacement(n/2)+1;
        return 1+Math.min(integerReplacement(n+1),integerReplacement(n-1));
        // Write your code here
    }
}
