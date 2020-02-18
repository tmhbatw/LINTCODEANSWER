package LINTCODE13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE1238 {
    /*Description
    * 给定一个整数数组，1 ≤ a[i] ≤ n（n = 数组的大小），一些元素出现两次，其他元素出现一次。
    * 找到在此数组中出现两次的所有元素。
    * */

    public List<Integer> findDuplicates(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            while(cur!=i+1&&cur>=1&&cur<=nums.length){
                if(nums[cur-1]==cur)
                    break;
                int temp=nums[cur-1];
                nums[cur-1]=cur;
                cur=temp;
            }
            nums[i]=cur;
            System.out.println(Arrays.toString(nums));
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                list.add(nums[i]);
        }
        Collections.sort(list);
        return list;
        // write your code here
    }
}
