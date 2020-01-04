package LINTCODE8;

import java.util.PriorityQueue;

public class LINTCODE791 {
    /*Description
    * 给出n个数，现在要将这n个数合并成一个数，每次只能选择两个数a,b合并，
    * 每次合并需要消耗a+b的能量，输出将这n个数合并成一个数后消耗的最小能量。
    * */

    /*Solution
    * 贪心算法，每次取最小的两个数相加即可
    *
    * */

    public int mergeNumber(int[] numbers) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int num:numbers)
            queue.add(num);
        int consume=0;
        while(queue.size()>1){
            int a=queue.poll();
            int b=queue.poll();
            consume+=a+b;
            queue.add(a+b);
        }
        return consume;
        // Write your code here
    }

    public static void main(String[] args){
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
    }
}
