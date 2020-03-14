package LINTCODE18;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1780 {
    /*Description
    * 给定一个包含候选人姓名的数组. 数组中一个候选人的名字代表他获得了一张选票. 返回的票最多的人的名字.
    * */

    public String candidateWithTheMostVotes(List<String> votes) {
        Map<String,Integer> map=new HashMap<>();
        for(String cur:votes){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        int time=0;
        String result="";
        for(Map.Entry entry:map.entrySet()){
            int curTime= (int) entry.getValue();
            String cur=(String)entry.getKey();
            if(curTime>time||curTime==time&&cur.compareTo(result)<0) {
                result = cur;
                time=curTime;
            }
        }
        return result;
        // Write your code here
    }
}
