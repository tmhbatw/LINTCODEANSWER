package LINTCODE15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1455 {
    /*Description
    * 如果一个数组中只包含一个出现了奇数次的数，那么数组合法，否则数组不合法。
    * 输入一个只包含正整数的数组 a，判断该数组是否合法，如果合法返回该出现了奇数次的数，如果不合法返回 -1。
    * */

    public int isValid(List<Integer> a) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:a){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int result=-1;
        for(Map.Entry entry:map.entrySet()){
            int time= (int) entry.getValue();
            if(time%2==1){
                if(result==-1)
                    result=(int)entry.getKey();
                else
                    return -1;
            }
        }
        return result;
        // Write your code here
    }
}
