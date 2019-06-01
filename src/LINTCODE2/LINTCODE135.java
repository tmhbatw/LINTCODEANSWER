package LINTCODE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE135 {
    /*Description
    *Given a set of candidtate numbers candidates and a target number target. Find all unique combinations in candidates where the numbers sums to target.
    * The same repeated number may be chosen from candidates unlimited number of times.
    * */

    /*Solution
    * 递归回溯即可
    * 对原数组进行排序、去重有利于减小时间复杂度
    * */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        candidates=delete(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        recursion(result,res,candidates,target,0);
        return result;
        // write your code here
    }

    private int[] delete(int[] nums){
        int i=1,j=1;
        for(;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[j++]=nums[i];
            }
        }
        return Arrays.copyOf(nums,j);
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int[] candidates,int target,int start){
        if(target==0){
            result.add(res);
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target)
                break;
            List<Integer> ress= new ArrayList<>();
            ress.addAll(res);
            ress.add(candidates[i]);
            recursion(result,ress,candidates,target-candidates[i],i);
        }
    }

}
