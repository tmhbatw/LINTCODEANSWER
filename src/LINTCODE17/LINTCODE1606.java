package LINTCODE17;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1606 {
    /*Description
    *在商店里面，物品都有编码和价格，在结账的时候结账系统是通过编码和价格来进行结算的
    * 现在有n个物品，给出每个物品的编码和价格，让你按价格排个序，并输出排序之后的n个物品的编码
    * 1<=n<=1000000
    * 1<=n<=1000000，价格不会超过1000000
    * */

    public int[] strangeSort(int n, int[] num, int[] cost) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(int i=0;i<num.length;i++)
            queue.add(new int[]{num[i],cost[i]});
        int[] result=new int[n];
        for(int i=0;i<result.length;i++)
            result[i]=queue.poll()[0];
        return result;
        //
    }
}
