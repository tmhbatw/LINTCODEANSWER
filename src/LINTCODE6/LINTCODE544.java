package LINTCODE6;

import java.util.PriorityQueue;

public class LINTCODE544 {
    /*Description
    *在一个数组中找到前K大的数
    * */

    /*Solution
    * 想到了最小堆的思想
    * */

    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int num:nums){
            queue.add(num);
            if(queue.size()==k+1)
                queue.poll();
        }
        int[] result=new int[k];
        for(int j=k-1;j>=0;j--)
            result[j]=queue.poll();
        return result;
        // write your code here
    }
}
