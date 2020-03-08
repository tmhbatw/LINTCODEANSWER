package LINTCODE18;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1779 {
    /*Description
    * 给定一个数组，返回具有重复元素的最短子数组长度。
    * 如果数组没有具有重复元素的子数组，则返回 -1。
    * */

    public int getLength(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        int result=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int cur=arr[i];
            if(map.containsKey(cur)){
                result=Math.min(i-map.get(cur)+1,result);

            }
            map.put(cur,i);
        }
        return result==Integer.MAX_VALUE?-1:result;
        // Write your code here.
    }
}
