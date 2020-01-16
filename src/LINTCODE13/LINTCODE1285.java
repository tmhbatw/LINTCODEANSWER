package LINTCODE13;

public class LINTCODE1285 {
    /*Description
    * 给定一个整数（32位有符号整数），写一个方法判断这个数字是否为4的乘方。
    * */

    public boolean isPowerOfFour(int num) {
        if(num==0)
            return false;
        while(num%4==0)
            num/=4;
        return num==1;
        // Write your code here
    }
}
