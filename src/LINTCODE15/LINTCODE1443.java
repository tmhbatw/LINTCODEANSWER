package LINTCODE15;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1443 {
    /*Description
    * 给你一个只由字母'A'和'B'组成的字符串s，找一个最长的子串，要求这个子串里面'A'和'B'的数目相等，输出该子串的长度。
    * */

    public int getAns(String S) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int result=0;
        int curCount=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='A')
                curCount++;
            else
                curCount--;
            if(map.containsKey(curCount))
                result=Math.max(result,i-map.get(curCount));
            else
                map.put(curCount,i);
        }
        return result;
        // Write your code here
    }
}
