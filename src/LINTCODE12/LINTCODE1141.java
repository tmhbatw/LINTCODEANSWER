package LINTCODE12;

public class LINTCODE1141 {
    /*Description
    *给定年份和月份，返回这个月的天数。
    * */

    public int getTheMonthDays(int year, int month) {
        int[] res=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        if(month!=2)
            return res[month-1];
        if(year%400==0)
            return 29;
        if(year%100==0)
            return 28;
        if(year%4==0)
            return 29;
        return 28;
        // write your code here
    }
}
