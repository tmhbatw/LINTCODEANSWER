package LINTCODE13;

import java.util.HashMap;

public class LINTCODE1206 {
    /*Description
    *你有两个数组 nums1和nums2（互不重复），其中nums1是nums2的子集。 在nums2的相应位置找到nums1所有元素的下一个更大数字。
    * nums1中的数字x的下一个更大数字是nums2中x右边第一个更大的数字。 如果它不存在，则为此数字输出-1。
    * */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++)
            map.put(nums2[i],i);
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int index=map.get(nums1[i]);
            for(int j=index+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
            if(result[i]==0)
                result[i]=-1;
        }
        return result;
        // Write your code here
    }
}
