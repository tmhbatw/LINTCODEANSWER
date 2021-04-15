package LINTCODE13;

public class LINTCODE1229 {
    /*Description
    *给你一个包含正整数和负整数的数组。如果在某个位置包含正整数 n ，那么你将从这个位置出发正向（向右）移动 n 步；
    * 相反的，如果在某个位置包含负整数 -n ，那么你将从这个位置出发反向（向左）移动 n 步。数组被视为首尾相连的，
    * 即第一个元素视为在最后一个元素的右边，最后一个元素视为在第一个元素的左边。你的任务是判断其中是否包含环：
    * 一个环从某一个确定的位置出发，在经过若干次移动后仍能回到这个位置。环中必须包含一个以上的元素，且环必须是单向（不是正向就是反向）移动的。
    * */

    public boolean circularArrayLoop(int[] nums) {
        int length=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                continue;
            if(nums[i]==length||nums[i]==-length){
                nums[i]=0;
                continue;
            }
            boolean positive=nums[i]>0;
            int curIndex=i;
            while(true){
                int temp=nums[curIndex];
                nums[curIndex]=0;
                curIndex+=temp;
                if(curIndex<0){
                    curIndex%=length;
                    curIndex+=length;
                }
                if(curIndex>=length)
                    curIndex%=length;
                if(curIndex==i)
                    return true;
                if(nums[curIndex]==0||(positive^nums[curIndex]>0))
                    break;

            }
        }
        return false;
        // Write your code here
    }
}
