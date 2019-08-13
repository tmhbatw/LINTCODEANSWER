package LINTCODE7;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE685 {
    /*Description
    * 给一个连续的数据流,写一个函数返回终止数字到达时的第一个唯一数字（包括终止数字）,如果找不到这个终止数字, 返回 -1.
    * */

    public int firstUniqueNumber(int[] nums, int number) {
        Map<Integer,Integer> map=new HashMap<>();
        int index=-1;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(nums[i]==number){
                index=i;
                break;
            }
        }
        if(index==-1)
            return index;
        for(int i=0;i<=index;i++){
            if(map.get(nums[i])==1)
                return nums[i];
        }
        return -1;
        // Write your code here
    }
}
