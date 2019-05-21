package LINTCODE;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE16 {

    /*Description
    *Given a list of numbers with duplicate number in it. Find all unique permutations.
    * */

    /*Solution
    * 与15题解题思路基本相同，增加一部去重步骤
    * */


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();//用来保存结果
        List<Integer> res=new ArrayList<>();//用来保存一次排序的结果
        recursion(result,res,nums);
        changeResult(result);
        return result;
    }
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
    private void changeResult(List<List<Integer>> result){
        for(int i=0;i<result.size();i++){
            List<Integer> curr=result.get(i);
            for(int j=result.size()-1;j>i;j--){
                if(curr.equals(result.get(j)))
                    result.remove(j);
            }
        }
    }

}
