package LINTCODE13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1236 {
    /*Description
    * 给定一个整数数组，其中1 ≤ a[i] ≤ n (n =数组的大小)，一些元素出现两次，其他元素出现一次。
    * 找到 [1,n] 中所有没有出现在此数组中的元素。
    * 你可以在没有额外空间和O(n)运行时的情况下完成吗？ 您可以认为返回的列表不计为额外空间。
    * */

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            while(cur>=1&&cur<=nums.length&&nums[cur-1]!=cur){
                int temp=nums[cur-1];
                nums[cur-1]=cur;
                cur=temp;
            }
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                result.add(i+1);
        }
        return result;
        // write your code here
    }
}
