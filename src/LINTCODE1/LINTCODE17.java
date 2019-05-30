package LINTCODE1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE17 {
    /*Description
    *Given a set of distinct integers, return all possible subsets.
    *Elements in a subset must be in non-descending order.
    * The solution set must not contain duplicate subsets
    * */

    /*Solution
    * 使用递归回溯方法，暴力遍历所有子集
    *需要注意的是虽然题目要求没有明确提出，但是答案要求子集以升序输出
    *  */

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>(); //用来保存所有结果
        result.add(Collections.emptyList());
        for(int i=0;i<nums.length;i++){
            List<Integer> res=new ArrayList<>();      //用来保存一次遍历的结果
            res.add(nums[i]);
            result.add(res);
            recursion(result,res,i+1,nums);
        }
        return result;
        // write your code here
    }

    //其中数字n作为遍历开始的数组下标,以及递归跳出的判别标志
    private void recursion(List<List<Integer>> result,List<Integer> res,int n,int[] nums){
        if(n==nums.length)
            return;
        for(int i=n;i<nums.length;i++){
            List<Integer> re=new ArrayList<>();
            re.addAll(res);
            re.add(nums[i]);
            result.add(re);
            recursion(result,re,n+1,nums);
        }
    }
}
