package LINTCODE15;

import java.util.Arrays;

public class LINTCODE1478 {
    /*Description
    *给出一个数组，在数组中找到两个数，使得它们的和最接近目标值但不超过目标值，返回它们的和
    * */

    public int closestTargetValue(int target, int[] array) {
        Arrays.sort(array);
        int left=0;
        int right=array.length-1;
        int result=Integer.MIN_VALUE;
        while(left<right){
            int cur=array[left]+array[right];
            if(cur==target)
                return target;
            if(cur>target)
                right--;
            else{
                result=Math.max(result,cur);
                left++;
            }
        }
        return result==Integer.MIN_VALUE?-1:result;
        // Write your code here
    }
}
