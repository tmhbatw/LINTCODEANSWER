package LINTCODE1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE51 {

    /*Description
    * Given a list of integers, which denote a permutation.
    * Find the previous permutation in ascending order.
    * */

    /*Solution
    *从后往前找到最近的第一个数字，使得该数字到最后的数字序列不为降序排列
    * 重新排列该位置到最后数字的顺序,使小于找到下标的数字作为开头，其他数字降序排列
    * 如果找不到该位置则翻转数组：
    * */

    public List<Integer> previousPermuation(List<Integer> nums) {
        if(nums.size()<=1)
            return nums;
        int index=nums.size()-2;
        while(index>=0&&nums.get(index)<=nums.get(index+1)){
            index--;
        }
        return reorder(nums,index);
        // write your code here
    }

    private List<Integer> reorder(List<Integer> nums,int index){
        if(index==-1){
            Collections.reverse(nums);
            return nums;
        }
        else{
            List<Integer> list=new ArrayList<>();
            int curr=nums.get(index);
            for(int i=0;i<index-1;i++){
                list.add(nums.get(i));
            }
            int temp=nums.size()-1;
            int start=0;
            for(;temp>index;temp--){
                if(start==0&&nums.get(temp)<curr) {
                    start = temp;
                    continue;
                }
                list.add(nums.get(temp));
            }
            for(int i=index;i<list.size();i++){
                if(curr>list.get(i)) {
                    list.add(i, curr);
                    break;
                }
            }
            list.add(index,list.get(start));
            if(list.size()<nums.size())
                list.add(curr);
            return list;
        }
    }


}
