package LINTCODE7;

public class LINTCODE608 {

    /*Description
    * 给定一个已经 按升序排列 的数组，找到两个数使他们加起来的和等于特定数。
    * 函数应该返回这两个数的下标，index1必须小于index2。注意返回的值不是 0-based。
    * */


    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            int second=getIndex(nums,i+1,nums.length-1,target-nums[i]);
            if(second!=-1)
                return new int[]{i+1,second+1};
        }
        return null;
        // write your code here
    }

    private int getIndex(int[] nums,int start,int end,int target){
        if(start>end)
            return -1;
        int mid=start+(end-start)/2;
        if(nums[mid]==target)
            return mid;
        else if (nums[mid]<target)
            return getIndex(nums,mid+1,end,target);
        else
            return getIndex(nums,start,end-1,target);
    }
}
