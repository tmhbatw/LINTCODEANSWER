package LINTCODE7;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE641 {
    /*Description
    * 给定一个排序整数数组，其中元素的取值范围为[lower，upper] (包括边界)，返回其缺少的范围。
    * */

    /*Solution
    * 注意可能出现越界问题
    * */



    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res=new ArrayList<>();
        long start=lower;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<lower||nums[i]>upper||i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]==start){
                start++;
                continue;
            }
            if(nums[i]-start==1){
                res.add(new String(""+start));
            }else{
                res.add(new String(start+"->"+(nums[i]-1)));
            }
            start=(long)nums[i]+1;
        }
        if(start==upper){
            res.add(start+"");
        }else if(start<upper) {
            res.add(start + "->" + upper);
        }
        return res;
        // write your code here
    }
}
