package LINTCODE9;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE836 {
    /*Description
    * 给定一个整数数组nums和一个正整数k，是否有可能能够把这个数组分成k个非空的子集，满足子集的权重全部都相等。
    * */

    private boolean res=false;
    private int target;
    public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        target = Arrays.stream(nums).sum();
        if(target%k!=0)
            return false;
        target/=k;
        int[] sum=new int[k];
        dfs(nums,sum,nums.length-1);
        return res;
        // write your code here
    }

    private void dfs(int[] nums, int[] sum, int index) {
        if(res)
            return ;
        if(index==-1){
            res=true;
            return;
        }
        Set<Integer> curSet=new HashSet<>();
        for(int i=0;i<sum.length;i++){
            if(nums[index]+sum[i]>target||curSet.contains(sum[i]))
                continue;
            sum[i]+=nums[index];
            System.out.println(Arrays.toString(sum));
            curSet.add(sum[i]);
            dfs(nums,sum,index-1);
            sum[i]-=nums[index];
        }
    }

    public static void main(String[] args){
        int[] num=new int[]{4, 3, 2, 3, 5, 2, 1};
        int k=3;
        System.out.println(new LINTCODE836().partitiontoEqualSumSubsets(num,k));
    }
}
