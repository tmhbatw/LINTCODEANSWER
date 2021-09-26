package LINTCODE3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE215 {
    /*Description
    *实现一个速率限制器，提供一个方法:is_ratelimited(timestamp、event、rate、increment)。
    * timestamp:当前时间戳，它是一个整数，单位为秒。
    * event:不同事件的字符串。 例如“登录”或“注册”。
    * rate:限额的比率。 1/s（每秒1次），2/m（每分钟2次），10/h（每小时10次），100/d（每天100次）。
    *  格式为[integer]/[S/M/H/D]。
    * increment:我们是否应该增加计数器。 （或将此请求视为给定事件的命中）
    * 该方法应返回true或false以指示事件是否受限。
    * 注意：登陆次数里不包含登陆失败的情况。
    * */

    Map<String, List<Integer>> map=new HashMap<>();
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {


        map.putIfAbsent(event,new ArrayList<>());
        String[] s=rate.split("/");
        int time=Integer.parseInt(s[0]);
        int preTime=timestamp;
        switch (s[1]){
            case "m":
                preTime-=59;
                break;
            case "h":
                preTime-=60*60-1;
                break;
            case "d":
                preTime-=60*60*24-1;
                break;
        }
        int count=getCount(map.get(event),preTime);

        if(count<time){
            if(increment)

                map.get(event).add(timestamp);
            return false;
        }
        return true;
        // write your code here
    }

    private int getCount(List<Integer> list,int start){
        if(list.size()==0)
            return 0;
        if(list.get(list.size()-1)<start)
            return 0;
        int l=0,r=list.size()-1;
        while(l<r){
            int mid=(l+r)/2;
            if(list.get(mid)<start)
                l=mid+1;
            else
                r=mid;
        }
        return list.size()-l;
    }
}
