package LINTCODE1;

public class LINTCODE76 {
    /*Description
    *Given a sequence of integers, find the longest increasing subsequence (LIS).
    * You code should return the length of the LIS.
    * */

    /*Solution
    * 可以创建一个数组用来储存最长的升序子序列
    * 当下一个数大于数组最大数时，将该数加入数组
    * 当小于最大数时，使用二分法查找它小于某一个数且大于该数前一个数的位置进行替换
    * 最后返回数组长度即可
    * */

    public int longestIncreasingSubsequence(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] result=new int[nums.length];
        int temp=0;
        result[temp++]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[temp-1]){
                nums[temp++]=nums[i];
            }else{
                int left=0;
                int right=temp-1;
                while(left<=right){
                    int mid=(left+right)/2;
                    if(nums[mid]>nums[i]&&(mid==0||nums[mid-1]<nums[i]))
                        nums[mid]=nums[i];
                    else if(nums[mid]<nums[i]){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
            }
        }
        return temp;
        // write your code here
    }

    //使用二分法定位到被替换掉的下标
    private void replace(int[] nums,int temp,int key){
        if(key>nums[temp-1]){
            nums[temp++]=key;
        }else{
            int left=0;
            int right=temp-1;
            while(left<=right){
                int mid=(left+right)/2;
                if(nums[mid]>key&&(mid==0||nums[mid-1]<key))
                    nums[mid]=key;
                else if(nums[mid]<key){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
    }


}
