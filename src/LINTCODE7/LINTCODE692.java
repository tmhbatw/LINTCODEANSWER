package LINTCODE7;

import java.util.HashMap;

public class LINTCODE692 {
    /*Description
    *给一个数组和一个滑动窗口的大小, 求每一个窗口内只出现一次的元素的个数和
    * */

    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>(k);
        int result=0;
        int count=0;
        for(int i=0;i<k&&i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                count++;
            }else{
                map.put(nums[i],map.get(nums[i])+1);
                count--;
            }
        }
        result+=count;
        for(int i=k;i<nums.length;i++){
            System.out.println(count);
            int reduce=nums[i-k];
            map.put(reduce,map.get(reduce)-1);
            if(map.get(reduce)==0)
                count--;
            if(map.get(reduce)==1)
                count++;
            int add=nums[i];
            map.put(add,map.getOrDefault(add,0)+1);
            if(map.get(add)==1)
                count++;
            if(map.get(add)!=1)
                count--;
            result+=count;
        }
        return result;
        // write your code here
    }
}
