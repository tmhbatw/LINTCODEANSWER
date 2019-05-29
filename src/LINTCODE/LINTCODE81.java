package LINTCODE;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE81 {


    public int[] medianII(int[] nums) {
        /*Description
        *Numbers keep coming, return the median of numbers at every time a new number added.
        * Challenge
        * Total run time in O(nlogn).
        * */

        /*Solution
        * 创建一个大根堆、一个小根堆，分别存储加入当前nums中的数字后题目要求的中位数左边以及右边的数，其中中位数存储在右边的小根堆中
        * 当后面的数字大于上一中位数则加入右边的堆，反之则加入左边的堆
        * 保证左右两边个数始终相差《=2个且右边的个数比较多
        * 输出右边的顶元素即可
        * */
        int[] result=new int[nums.length];
        //创建一个大根堆、一个小根堆，分别存储加入当前nums中的数字后题目要求的中位数左边以及右边的数，其中中位数存储在右边的小根堆中
        if(nums.length==0)
            return result;
        PriorityQueue<Integer> right=new PriorityQueue<>();
        PriorityQueue<Integer> left=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        right.add(nums[0]);
        result[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(right.peek()<nums[i])
                right.add(nums[i]);
            else
                left.add(nums[i]);
            if(right.size()==left.size()){
                right.add(left.poll());
            }else if(right.size()-left.size()>=3){
                left.add(right.poll());
            }
            result[i]=right.poll();
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){ //大顶堆，容量11
//            @Override
//            public int compare(Integer i1,Integer i2){
//                return i2-i1;
//            }
//        });
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        })        ;
        queue.add(3);
        queue.add(5);
        queue.add(4);
        queue.add(2);
        queue.add(2);
        queue.add(6);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
