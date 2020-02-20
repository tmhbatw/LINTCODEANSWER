package LINTCODE16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1536 {
    /*Description
    * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    * 你的算法时间复杂度必须是 O(log n) 级别。
    * 如果数组中不存在目标值，返回 [-1, -1]。
    * */

    public List<Integer> searchRange(List<Integer> nums, int target) {
        List<Integer> result=new ArrayList<>();
        int left=0,right=nums.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if((mid==0||nums.get(mid-1)<target)&&nums.get(mid)==target){
                result.add(mid);
                break;
            }
            else if(nums.get(mid)>=target)
                right=mid-1;
            else
                left=left+1;
        }
        if(result.size()==0){
            result.add(-1);
            result.add(-1);
            return result;
        }
        left=0;
        right=nums.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if((mid==nums.size()-1||nums.get(mid+1)>target)&&nums.get(mid)==target){
                result.add(mid);
                return result;
            }
            else if(nums.get(mid)<=target)
                left=mid+1;
            else
                right=mid-1;
        }
        return result;
        // Write your code here.
    }
}
