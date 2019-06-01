package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE138 {
    /*Description
     * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
     * */

    /*Solution
     * 嵌套循环即可解决
     * */

    public List<Integer> subarraySum(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                list.add(i);
                return list;
            }
            int result=nums[i];
            for(int j=i+1;j<nums.length;j++){
                result+=nums[j];
                if(result==0){
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return list;
        // write your code here
    }
}
