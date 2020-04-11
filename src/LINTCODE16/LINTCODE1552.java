package LINTCODE16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1552 {
    /*Description
    * 小明中午出去买饮料，路过一家公共停车场，出于程序员的职业习惯，他很想知道这个停车场上午的最大化利用率有多少。
    * 经与门卫大叔沟通，他获得了该停车场上午车辆入场时间与出场时间的记录表（数据格式参考样例输入），
    * 你能通过拿到的数据写一个函数快速的帮小明算出这家停车场，上午最多的时候同时停放了多少辆车吗？
    * */

    public int getMax(int[][] a) {
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        int result=0;
        for(int[] cur:a){
            if(cur[0]>=cur[1])
                continue;
            int start=cur[0];
            while(!queue.isEmpty()&&queue.peek()<=start)
                queue.poll();
            queue.add(cur[1]);
            result=Math.max(result,queue.size());
        }
        return result;
        // Write your code here
    }

    public static void main(String[] args){
        PriorityQueue<Integer> queue=new PriorityQueue<>();

        queue.add(2);

        queue.add(1);

        System.out.println(queue.poll());
    }
}
