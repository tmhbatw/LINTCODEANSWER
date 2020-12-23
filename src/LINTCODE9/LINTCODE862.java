package LINTCODE9;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE862 {
    /*Description
    * 给定一个"HH:MM"格式的时间，重复使用这些数字，返回下一个最近的时间。每个数字可以被重复使用任意次。
    * 保证输入的时间都是有效的。例如，"01:34"，"12:09" 都是有效的，而"1:34"，"12:9"都不是有效的时间。
    * */

    public String nextClosestTime(String time) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<5;i++){
            if(i!=2)
                set.add(time.charAt(i));
        }
        String cur=time;
        while(true){
            cur=addTime(cur);
            if(set.contains(cur.charAt(0))&&set.contains(cur.charAt(1))
                    &&set.contains(cur.charAt(3))&&set.contains(cur.charAt(4)))
                return cur;
        }
        // write your code here
    }
    private String addTime(String cur){
        if(cur.equals("23:59"))
            return "00:00";
        if(cur.contains("59")) {
            int curr=(Integer.parseInt(cur.substring(0, 2)) + 1);
            return  (curr<10?"0"+curr:curr)+ ":00";
        }
        int curr=(Integer.parseInt(cur.substring(3))+1);
        return cur.substring(0,3)+(curr<10?"0"+curr:curr);
    }

}
