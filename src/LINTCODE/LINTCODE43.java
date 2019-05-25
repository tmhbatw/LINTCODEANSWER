package LINTCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE43 {
    /*Description
    * 给定一个整数数组和一个整数 k，找出 k 个不重叠子数组使得它们的和最大。每个子数组的数字在数组中的位置应该是连续的。
    * 返回最大的和。
    * */

    /*Solution
    * 经典的动态规划问题
    *
    * */


//递归实现，时间复杂度超标
//    public static int maxSubArray(int[] nums, int k) {
//        List<Integer> list=new ArrayList<>();
//        list.add(Integer.MIN_VALUE);
//        int res=0;
//        recursion(list,res,nums,0,1,k);
//        System.out.println(res);
//        return list.get(0);
//    }
//    private static void recursion(List<Integer> result,int res,int[] nums,int start,int part,int k){
//        if(part==k){
//            res+=maxSearch(nums,start,nums.length);
//            if(result.get(0)<res){
//                result.add(0,res);
//            }
//            return;
//        }
//        for(int i=start;i<(nums.length-k+part);i++){
//            recursion(result,res+maxSearch(nums,start,i+1),nums,i+1,part+1,k);
//        }
//    }
//
//    private static int maxSearch(int[] nums,int n,int m){
//        int max=nums[n],curmax=nums[n];
//        for(int i=n+1;i<m;i++){
//            curmax=curmax>0?curmax+nums[i]:nums[i];
//            max=Math.max(curmax,max);
//        }
//        return max;
//    }

    public static void main(String[] args){
        int[] a={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,-2,1,-15,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(maxSubArray(a,1));
    }
}
