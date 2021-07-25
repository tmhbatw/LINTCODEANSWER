package LINTCODE19;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1879 {
    /*Description
    *给定一个已经按绝对值升序排列的数组，找到两个数使他们加起来的和等于特定数。
    * 函数应该返回这两个数的下标，index1必须小于index2。注意：数组的下标以0开始。
    * 你不能对该数组进行排序。
    * */

    int index1;
    int index2;
    int nextIndex1 = -1;
    int nextIndex2 = -1;
    int bound ;
    int[] nums;
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        this.nums=nums;
        this.bound=nums.length;
        for(index1 = nums.length-1;index1>=0;index1--){
            if(nums[index1]>0)
                break;
        }
        for(index2 = nums.length-1;index2>=0;index2--){
            if(nums[index2]<0)
                break;
        }
        List<List<Integer>> result=new ArrayList<>();
        //退化为一个单向数组
        if(index1==-1||index2==-1){
            int l=0,r=nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(l);
                    list.add(r);
                    result.add(list);
                    l++;
                    r--;
                }else{
                    if(nums[l]+nums[r]<target){
                        if(index1==-1)
                            r--;
                        else
                            l++;
                    }else{
                        if(index1==-1)
                            l++;
                        else
                            r--;
                    }
                }
            }
            return result;
        }
        while(nums[index1]>nums[index2]){
            if(nums[index1]+nums[index2]==target){
                List<Integer> list=new ArrayList<>();
                list.add(Math.min(index2,index1));
                list.add(Math.max(index1,index2));
                result.add(list);
                reduce();
                add();
            }
            else if(nums[index1]+nums[index2]<target)
                add();
            else
                reduce();
            if(index1==bound||index2==bound)
                break;
        }
        return result;
        // write your code here
    }

    private void reduce(){
        while(true){
            if(index1==0)
                nextIndex1 = 1;
            index1+=nextIndex1;
            if(index1==bound) {
                return;
            }
            if(nextIndex1==-1){
                if(nums[index1]>=0)
                    return;
            }else{
                if(nums[index1]<=0)
                    return;
            }
        }
    }

    private void add(){
        while(true){
            if(index2==0)
                nextIndex2 = 1;
            index2+=nextIndex2;
            if(index2==bound) {
                return;
            }
            if(nextIndex2==-1){
                if(nums[index2]<=0)
                    return;
            }else{
                if(nums[index2]>=0)
                    return;
            }
        }
    }

}
