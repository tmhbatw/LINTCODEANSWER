package LINTCODE4;

import java.util.*;

public class LINTCODE362 {

    /*Description
    *Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration
    *  from the start of the array, find the maximum number inside the window at each moving.
    * Challenge
    * O(n)时间复杂度
    * */

    /*Solution
    * 可以使用SortedMap或者Deque数据结构，但是无法保证O(n)时间复杂度
    * 可以是用一个双向队列，队列中保存窗口内单调递减的数字排列组合的下标
    * 每当窗口移动时，判断当前数字是否大于前面的数，如果大于则将他们踢出（因为显而易见的，最大值已经与前面的数字无关）
    * (虽然复杂度降低了可是消耗时间变多了）
    * */

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        if(k==0)
            return Collections.emptyList();
        List<Integer> result=new ArrayList<>();
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<k-1;i++){
            while(!queue.isEmpty()&&nums[queue.getLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.add(i);
        }
        for(int i=k-1;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.getLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.add(i);
            result.add(nums[queue.getFirst()]);
            if(queue.getFirst()==i-k+1)
                queue.pollFirst();
        }
        // write your code here

        return result;
    }


}
