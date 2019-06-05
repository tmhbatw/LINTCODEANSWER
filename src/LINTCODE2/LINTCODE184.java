package LINTCODE2;

import java.util.PriorityQueue;
import java.util.Queue;

public class LINTCODE184 {
    /*Description
    * Given a list of non negative integers, arrange them such that they form the largest number.
    * */

    /*Solution
    * 可以创建一个小根堆进行排序
    * 排序的规则对于i,j两个整数如果ij>ji,那么i在j的前面
    *
    * */
    public String largestNumber(int[] nums) {
        String result="";
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1, o2) -> {
            if((o1+"").length()==(o2+"").length())
                return o2-o1;
            String oo2=o2+""+o1;
            String oo1=o1+""+o2;
            return (int) (Long.parseLong(oo2)-Long.parseLong(oo1));
        });
        for(int i:nums)
            queue.add(i);
        while(!queue.isEmpty())
            result+=queue.poll();
        if(result.charAt(0)=='0')
            return "0";
        return result;
        // write your code here
    }


}
