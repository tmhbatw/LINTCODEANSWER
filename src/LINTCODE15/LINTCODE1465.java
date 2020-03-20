package LINTCODE15;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1465 {
    /*Description
    * 有 n 种不同的任务，执行时间为 t[]，成功概率为 p[]。当有一个任务完成，或者所有任务都失败的情况下，行动结束。
    * 以不同的顺序执行任务，期望停止行动的时间一般是不同的。请你求出以何种顺序执行任务才能使期望行动结束时间最短？
    * 如果两种任务顺序的期望行动结束时间相同，返回字典序最小的任务顺序。
    * */

    public int[] getOrder(int n, int[] t, double[] p) {
        PriorityQueue<double[]> queue=new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[1]==o2[1])
                    return (int)o1[0]-(int)o2[0];
                return o2[1]>o1[1]?-1:+1;
            }
        });
        for(int i=1;i<=n;i++){
            queue.add(new double[]{i,t[i-1]/p[i-1]});
            System.out.println(i+" "+p[i-1]/t[i-1]);
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++)
            result[i]= (int) queue.poll()[0];
        return result;
        // Write your code here
    }
    public static void main(String[] args){
        System.out.println(6/0.60);
    }
}
