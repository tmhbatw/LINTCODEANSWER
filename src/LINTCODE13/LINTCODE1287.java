package LINTCODE13;

import java.util.Stack;

public class LINTCODE1287 {
    /*Description
    *给定未排序的数组，返回是否在数组中存在递增的长度为3的子序列。
    * 完整的功能应为：
    * 如果存在i, j, k，使得arr[i] < arr[j] < arr[k]，且0 ≤ i < j < k ≤ n-1，则返回true，否则返回false。
    * 您的算法应该以O(n)时间复杂度和O(1)空间复杂度运行。
    * */

    public boolean increasingTriplet(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        for(int num:nums){

               if(!stack.isEmpty()&&stack.peek()>=num){
                   stack.pop();
               }

            stack.push(num);
        }
        return stack.size()>=3;
        // write your code
    }
}
