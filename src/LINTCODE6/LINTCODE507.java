package LINTCODE6;

import java.util.Arrays;

public class LINTCODE507 {
    /*Description
    * Given an unsorted array nums, reorder it such that
    * nums[0] < nums[1] > nums[2] < nums[3]....
    * */
    /*Solution
    * 与508题相似
    * 排序后交叉摆放
    * 首先获取一个排序好的数组，将排序好的数组依次加入目标数组中即可
    * */

    public void wiggleSort(int[] nums) {
        // write your code here
        int[] num=nums.clone();
        Arrays.sort(num);
        int length=nums.length;
        int half=length/2;
        int i=0,j=nums.length%2==0?half:half+1;
        while(i*2<nums.length-1){
            nums[i*2]=num[half-1-i];
            nums[i*2+1]=
                    num[length-1-i++];

        }
        if(nums.length%2==1)
            nums[2*i]=num[i];
    }
}
