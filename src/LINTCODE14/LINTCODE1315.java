package LINTCODE14;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1315 {
    /*Description
    * 给定一个没有重复的有序整数数组，用一系列连续区间的形式返回数组的范围。
    * */

    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1||nums[i+1]-nums[i]!=1) {
                result.add(String.valueOf(nums[i]));
                continue;
            }
            int index=1;
            while(i+index<nums.length&&nums[i+index]-nums[i]==index)
                index++;
            result.add(nums[i]+"->"+nums[i+index-1]);
            i+=index-1;
        }
        return result;
        // Write your code here
    }
}
