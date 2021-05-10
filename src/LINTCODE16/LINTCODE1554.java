package LINTCODE16;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1554 {
    /*Description
    * 给一个表示时间的字符串time，例如"12:34"(这是一种合法的输入数据)，和查找过去24小时内的最近时间，
    * 不包括重复的数字。 如果输入的是最小的time"00:00"，返回的答案是最大的23:59。如果输入是非法的，则返回-1。
    * */

    public String lastTime(String time) {
        if(!isIllegalTime(time))
            return "-1";
        String[] t=time.split(":");
        int hour=Integer.parseInt(t[0]);
        int min =Integer.parseInt(t[1]);
        if(hour>=24||min>=60)
            return "-1";
        return getPreTime(hour,min);
        // Write your code here
    }

    private String getPreTime(int hour,int min){
        if(hour==0&&min==0)
            return "23:59";
        min--;
        if(min==-1){
            min=59;
            hour--;
        }
        if(isSimpleNumber(hour,min)){
            return getRes(hour,min);
        }
        return getPreTime(hour,min);
    }

    private String getRes(int hour,int min){
        return (hour<10?"0"+hour:hour+"")+":"+(min<10?"0"+min:min+"");
    }

    private boolean isSimpleNumber(int hour,int min){
        Set<Integer> set=new HashSet<>();
        set.add(hour%10);
        set.add(hour/10);
        set.add(min%10);
        set.add(min/10);
        return set.size()==4;
    }

    private boolean isIllegalTime(String time){
        if(time==null||time.length()!=5)
            return false;
        return isIntegerChar(time.charAt(0))&&isIntegerChar(time.charAt(1))
                &&isIntegerChar(time.charAt(3))&&isIntegerChar(time.charAt(4))&&time.charAt(2)==':';
    }

    private boolean isIntegerChar(char cur){
        return cur<='9'&&cur>='0';
    }
}
