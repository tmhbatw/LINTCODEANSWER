package LINTCODE15;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1457 {
    /*Description
    * 给定一个数组arr和一个非负整数k，你需要从这个数组中找到一个连续子数组，使得这个子数组的和为k。
    * 返回这个子数组的长度。如果有多个这样的子串，返回结束位置最小的，如果还有多个，返回起始位置最小的。如果找不到这样的子数组，返回-1。
    * */

    public int searchSubarray(int[] arr, int k) {
        if(arr==null||arr.length==0)
            return -1;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int curSum=0;
        for(int i=0;i<arr.length;++i) {
            curSum += arr[i];
            if(map.containsKey(curSum-k))
                return i-map.get(curSum-k);
            if(!map.containsKey(curSum))
                map.put(curSum,i);
        }
        return -1;
        // Write your code here
    }
}
