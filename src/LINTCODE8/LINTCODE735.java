package LINTCODE8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE735 {
    /*Description
    * 给一整数数组, 用当前元素之后数组中的最大元素来替换当前元素(右侧的最大元素). 因为最后一个元素的右边没有元素了,
    * 所以用 -1 来替换这个值. 举个例子, 如果数组为 [16,17,4,3,5,2], 那么它就需要修改为 [17,5,5,5,2,-1].
    * */

    public void arrayReplaceWithGreatestFromRight(int[] nums) {
        if(nums.length==0)
            return;
        int max=nums[nums.length-1];
        nums[nums.length-1]=-1;
        for(int j=nums.length-2;j>=0;j--){
            int temp=nums[j];
            nums[j]=max;
            max=Math.max(max,temp);
        }
        // Write your code here.
    }
}
