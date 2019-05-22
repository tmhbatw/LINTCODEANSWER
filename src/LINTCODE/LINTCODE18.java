package LINTCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE18 {
    /*Description
    *Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
    *Each element in a subset must be in non-descending order.
    * The ordering between two subsets is free.
    * The solution set must not contain duplicate subsets.
    * */

    /*Solution
    * 与17题解题思路基本一致，增加一部去重复的方法，去重复方法如下
    * */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>(); //用来保存所有结果
        result.add(Collections.emptyList());
        for(int i=0;i<nums.length;i++){
            List<Integer> res=new ArrayList<>();      //用来保存一次遍历的结果
            res.add(nums[i]);
            result.add(res);
            recursion(result,res,i+1,nums);
        }
        removeResult(result);
        return result;
        // write your code here
        // write your code here
    }
    private void recursion(List<List<Integer>> result,List<Integer> res,int n,int[] nums){
        if(n==nums.length)
            return;
        for(int i=n;i<nums.length;i++){
            List<Integer> re=new ArrayList<>();
            re.addAll(res);
            re.add(nums[i]);
            result.add(re);
            recursion(result,re,i+1,nums);
        }

    }

    private void removeResult(List<List<Integer>> result){
        for(int i=0;i<result.size();i++){
            List<Integer> res=result.get(i);
            for(int j=result.size()-1;j>i;j--){
                if(res.equals(result.get(j)))
                    result.remove(j);
            }
        }
    }

}
