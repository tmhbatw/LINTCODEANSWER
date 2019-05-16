package LINTCODE;


import java.util.Arrays;

public class LINTCODE5 {
    public static int kthLargestElement(int n, int[] nums) {
        return quickSort(nums,0,nums.length-1,n);
    }
    private static int quickSort(int[] nums,int left,int right,int n){
        int flag=nums[left];
        int fla=left;
        left=left+1;
        while(left<=right){
            if(nums[right]<flag){
                right--;
                continue;
            }
            if(nums[left]>=flag){
                left++;
                continue;
            }
            int tem=nums[right];
            nums[right]=nums[left];
            nums[left]=tem;
            left++;
        }
        nums[fla]=nums[left-1];
        nums[left-1]=flag;
        System.out.println(Arrays.toString(nums));
        System.out.println(left);
        if(n==left){
            return nums[left-1];
        }else if(n>left){
            return quickSort(nums,left+1,nums.length-1,n);
        }else {
            return quickSort(nums, 0, left-1, n);
        }
    }
    public static void main(String[] args){
        int[] nums={9,3,2,4,8};
        System.out.println(kthLargestElement(3,nums));
    }
}
