package LINTCODE6;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE521 {
    /*Description
    * 给一个整数数组，去除重复的元素。
    * 你应该做这些事
    * 1.在原数组上操作
    * 2.将去除重复之后的元素放在数组的开头
    * .返回去除重复元素之后的元素个数
    * */

    /*Solution
    *使用一个set保存已出现过的数字，使用一个右边索引指示调换的数字索引
    * */

    public int deduplication(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int right=nums.length-1;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<right;i++){
            while (set.contains(nums[i]) && right > i) {
                int temp=nums[i];
                nums[i]=nums[right--];
                nums[i]=temp;
            }
            set.add(nums[i]);
        }
        return right+1;
        // write your code here
    }
}
