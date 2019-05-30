package LINTCODE1;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE15 {
    /*Description
    *Given a list of numbers, return all possible permutations.
    * */

    /*Solution
    * 解题思路与LINTCODE10基本相同
    * */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();//用来保存结果
        List<Integer> res=new ArrayList<>();//用来保存一次排序的结果
        recursion(result,res,nums);
        return result;
        // write your code here
    }

    //根据nums数组的长度判断回溯是否已经结束
    private void recursion(List<List<Integer>> result,List<Integer> res,int[] nums){
        if(nums.length==0) {
            result.add(res);
            return;
        }
        for(int i=0;i<nums.length;i++){
            List<Integer> re=new ArrayList<>();
            re.addAll(res);
            re.add(nums[i]);
            recursion(result,re,change(nums,i));
        }
    }
    private int[] change(int[] nums,int temp){
        int[] num=new int[nums.length-1];
        int i=0,j=0;
        while(i<num.length){
            if(j==temp){
                j++;
                continue;
            }
            num[i++]=nums[j++];
        }
        return num;
    }
}
