package LINTCODE19;

public class LINTCODE1871 {
    /*Description
    * 给一个24小时制的时间（00:00-23:59)，其中有一个或多个数字是问号。问号处可以用任何一个数字代替，问可以表示的最大时间是多少。
    * */

    public String MaximumMoment(String time) {
        String[] t=time.split(":");
        String hour=t[0];
        if(hour.equals("??"))
            t[0]="23";
        else if(hour.charAt(0)=='?'){
            char second=hour.charAt(1);
            if(second>='4')
                t[0]='1'+""+second;
            else
                t[0]='2'+""+second;
        }else if(hour.charAt(1)=='?'){
            if(hour.charAt(0)=='2')
                t[0]="23";
            else
                t[0]=hour.charAt(0)+""+'9';
        }
        String minute=t[1];
        if(minute.equals("??"))
            t[1]="59";
        else if(minute.charAt(0)=='?')
            t[1]="5"+minute.charAt(1);
        else if(minute.charAt(1)=='?')
            t[1]=minute.charAt(0)+"9";
        return t[0]+":"+t[1];
        //
    }
}
