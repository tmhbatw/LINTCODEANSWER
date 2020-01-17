package LINTCODE13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class LINTCODE1200 {
    /*Description
    * 根据N名运动员的得分，找到他们的相对等级和获得最高分前三名的人，
    * 他们将获得奖牌：“金牌”，“银牌”和“铜牌”。
    * */

    /*Solution
    * 使用一个map保存所有运动员的初始位置
    * */
    public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i],i);
        String[] res=new String[nums.length];
        Integer[] num=new Integer[nums.length];

        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1)
                res[map.get(nums[i])]="Gold Medal";
            else if(i==nums.length-2)
                res[map.get(nums[i])]="Silver Medal";
            else if(i==nums.length-3)
                res[map.get(nums[i])]="Bronze Medal";
            else
                res[map.get(nums[i])]= String.valueOf(nums.length-i);
        }
        return res;
        // write your code here
    }
}
