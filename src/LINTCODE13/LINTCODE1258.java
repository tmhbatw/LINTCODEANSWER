package LINTCODE13;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1258 {
    /*Description
    * 漂亮子数组的定义是具有 numOdds 个奇数元素的任何长度的数组。
    * 给定一个由整数组成的数组 nums 以及一个整数 numOdds，找出该数组中所有的漂亮子数组。
    * 只要子数组的开始索引以及结束索引不一样，那么这两个子数组就不一样。返回漂亮子数组的数量。
    * */

    public int BeautifulSubarrays(int[] nums, int numOdds) {
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]%2==1)
                list.add(i);
        }
        list.add(length);
        int result=0;
        for(int i=1;i<list.size()-numOdds;i++){
            int front=list.get(i)-list.get(i-1);
            int back=list.get(i+numOdds)-list.get(i+numOdds-1);
            result+=front*back;
        }
        return result;
        // write your code here
    }
}
