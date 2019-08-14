package LINTCODE8;

public class LINTCODE766 {
    /*Description
    * 判断给出的年份 n 是否为闰年. 如果 n 为闰年则返回 true
    * */

    public boolean isLeapYear(int n) {
        if(n%400==0)
            return true;
        if(n%100==0)
            return false;
        if(n%4==0)
            return true;
        return false;
        // write your code here
    }
}
