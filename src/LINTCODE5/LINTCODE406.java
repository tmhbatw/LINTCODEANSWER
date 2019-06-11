package LINTCODE5;

public class LINTCODE406 {

    /*Description
    *给定一个由 n 个正整数组成的数组和一个正整数 s ，请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 -1。
    * */

    /*Solution
    * 暴力遍历试一下不幸超时
    * 优化一下算法，使用滑动窗口方法试一下
    * */

    public int minimumSize(int[] nums, int s) {
        int i=0,j=0;
        int currSum=0;
        int result=Integer.MAX_VALUE;
        while(j<nums.length){
            currSum+=nums[j++];
            if(currSum>=s) {
                result = Math.min(j-i, result);
                currSum-=nums[i++];
            }
        }
        while(i<nums.length&&currSum>=s){
            currSum-=nums[i];
            result=Math.min(j-i,result);
        }
        if(result==Integer.MAX_VALUE)
            return -1;
        return result;
    }

/*    public int minimumSize(int[] nums, int s) {
        int result=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i;j<nums.length;j++){
                count+=nums[j];
                if(count>=s){
                    result=Math.min(j-i+1,result);
                }
            }
        }
        if(result==Integer.MAX_VALUE)
            return -1
        return result;
        // write your code here
    }*/
}
