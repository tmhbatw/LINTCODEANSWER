package LINTCODE17;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1613 {
    /*Description
    * 给定一个字符串数组lines, 每一个元素代表一个IP地址，找到出现频率最高的IP
    * */

    public String highestFrequency(String[] ipLines) {
        Map<String,Integer> map=new HashMap<>();
        for(String cur:ipLines)
            map.put(cur,map.getOrDefault(cur,0)+1);
        int max=0;
        String res="";
        for(Map.Entry entry:map.entrySet()){
            int value= (int) entry.getValue();
            if(value>max){
                value=max;
                res= (String) entry.getKey();
            }
        }
        return res;
        // Write your code here
    }
}
