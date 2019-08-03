package LINTCODE7;

public class LINTCODE636 {
    /*Description
    *给你一个 n 个整数的序列 a1,a2,...,an，一个 132 模式是对于一个子串 ai,aj,ak，满足 i < j < k 和 ai < ak < aj。
    * 设计一个算法来检查输入的这 n 个整数的序列中是否存在132模式。
    * n 会小于 20,000
    * */

    public boolean find132pattern(int[] nums) {
        boolean add;
        for(int i=nums.length-1;i>=0;i--){
            add=true;
            for(int j=i-1;j>=0;j--){
                if(add){
                    if(nums[i]>nums[j]){
                        add=false;
                        continue;
                    }
                }else{
                    if(nums[i]<nums[j])
                        return true;
                }
            }
        }
        return false;
        // write your code here
    }
}
