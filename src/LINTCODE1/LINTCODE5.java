package LINTCODE1;


public class LINTCODE5 {
    /*Description
    *Find K-th largest element in an array.
    * tips:You can swap elements in the array
    * */

    /*Solution
    *使用快速排序的方法
    * 取数组第一个数字，将大于它的k个数字移到左边，小于它的n-1-k个数字右移，将他放在第k+1位上，则这个数字第k+1大
    *向左或者向右递归即可求得第j大的数字
    * （PS：LINTCODE中50002测试用例包含数字相同情况）
    * */
    public static int kthLargestElement(int n, int[] nums) {
        return quickSort(nums,0,nums.length-1,n);
    }
    private static int quickSort(int[] nums,int left,int right,int n){
        int flag=nums[left];
        int fla=left;
        left=left+1;
        while(left<=right){
            if(nums[right]<=flag){
                right--;
                continue;
            }
            if(nums[left]>flag){
                left++;
                continue;
            }
            int tem=nums[right];
            nums[right]=nums[left];
            nums[left]=tem;
            left++;
            right--;
        }
        nums[fla]=nums[left-1];
        nums[left-1]=flag;
        if(n==left){
            return nums[left-1];
        }else if(n>left){
            return quickSort(nums,left,nums.length-1,n);
        }else {
            return quickSort(nums, fla, left-1, n);
        }
    }

}
