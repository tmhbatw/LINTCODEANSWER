package LINTCODE16;

public class LINTCODE1545 {
    /*Description
    *给定一个表示时间的字符串例如："12:34"（这是合法的输入数据），返回最近24小时内的最近时间。如果输入是非法的，则返回-1。
    * */

    public String lastTime(String time) {
        if(time==null||time.length()==0)
            return "-1";
        if(time.length()!=5)
            return "-1";
        if(time.charAt(2)!=':')
            return "-1";
        if(!isValid(time.charAt(0))||!isValid(time.charAt(1))||!isValid(time.charAt(3))||!isValid(time.charAt(4)))
            return "-1";
        if(time.equals("00:00"))
            return "23:59";
        String[] times=time.split(":");
        int hour=Integer.parseInt(times[0]);
        int min=Integer.parseInt(times[1]);
        if(hour>24||min>=60)
            return "-1";
        if(times[1].equals("00")){
            return hour<=10?"0"+(hour-1)+":"+"59":(hour-1)+":"+"59";
        }
        return times[0]+":"+(min-1);
        // Write your code here
    }

    private boolean isValid(char cur){
        return cur <= '9' && cur >= '0';
    }
}
