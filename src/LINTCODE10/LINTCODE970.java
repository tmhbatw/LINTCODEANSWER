package LINTCODE10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE970 {
    /*Description
    *给出两个数组a，b。a[i]代表第i部影片的版权费，b[i]代表第i部影片能卖的钱，
    * 现在本金k，问最后最多能赚多少钱。（每部影片只需要买一次版权，只能卖一次。）
    * */

    public int bigBusiness(int[] a, int[] b, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i=0;i<a.length;i++){
            queue.add(new int[]{a[i],b[i]});
        }
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            if(cur[0]>cur[1])
                continue;
            if(k<cur[0])
                break;
            k=k-cur[0]+cur[1];
        }
        return k;
        // Write your code here
    }
}
