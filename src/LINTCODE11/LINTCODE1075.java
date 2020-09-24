package LINTCODE11;

public class LINTCODE1075 {
    /*Description
    * 给定一个正整数数组nums。
    * 输出连续的子数组个数，每个子数组中元素的乘积小于k。
    * */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int length=nums.length;
        int last=0;
        int preProduct=1;
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>k){
                last=i+1;
                preProduct=1;
                continue;
            }
            while(last<length&&nums[last]*preProduct<k){
                preProduct*=nums[last];
                last++;
            }
            result+=last-i;
            preProduct/=nums[i];
        }
        return result;
        // Write your code here
    }
}
