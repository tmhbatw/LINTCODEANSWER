package LINTCODE14;

public class LINTCODE1318 {
    /*Description
    * 给定一个整数数组，找出数组中是否有两个不同的索引i和j，使得nums [i]和nums [j]之间差的绝对值最多为t，同时i和j之间差的绝对值最多为k。
    * */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            int cur=nums[i];
            for(int j=i+1;j<Math.min(length,k+i+1);j++){
                if(Math.abs(nums[j]-cur)<=t)
                    return true;
            }
        }
        return false;
        // Write your code here
    }

}
