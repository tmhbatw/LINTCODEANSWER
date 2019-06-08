package LINTCODE4;

import java.util.*;

public class LINTCODE360 {

    /*Description
    *给定一个包含 n 个整数的数组，和一个大小为 k 的滑动窗口,从左到右在数组中滑动这个窗口，找到数组中每个窗
    * 口内的中位数。(如果数组个数是偶数，则在该窗口排序数字后，返回第 N/2 个数字。)
    * */

    /*Solutionc
    *尝试一下创建一个小根堆以及一个大根堆，其中大根堆用来存储包含结果在内的窗口内部前N/2个数字
    * 小根堆则包含右边N/2个数字
    * 进行处理
     */

    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        if(k==0)
            return Collections.emptyList();
        PriorityQueue<Integer> large=new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> small=new PriorityQueue<>();
        List<Integer> result=new ArrayList<>();
        large.add(nums[0]);
        for(int i=1;i<k;i++){
            addNumber(small,large,nums[i]);
        }
        result.add(large.peek());
        for(int i=k;i<nums.length;i++){
            if(nums[i-k]<large.peek()){
                large.remove(nums[i-k]);
            }else{
                small.remove(nums[i-k]);
            }
            addNumber(small,large,nums[i]);
            result.add(large.peek());
        }
        return result;
        // write your code here
    }

    private void addNumber(PriorityQueue<Integer> small,PriorityQueue<Integer> large,int num){
        if(num>large.peek())
            small.add(num);
        else
            large.add(num);
        if(large.size()<small.size())
            large.add(small.poll());
        if(large.size()-small.size()==2)
            small.add(large.poll());
    }
}
