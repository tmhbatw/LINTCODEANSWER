package LINTCODE19;

import java.util.*;

public class LINTCODE1874 {
    /*Description
    * 给定一个每行中的元素个数不等的序列，其中同一行的元素单调递增。请在这个特定序列中找出第 K 小的数。
    * */

    public int kthSmallest(int[][] arr, int k) {
        PriorityQueue<int[]> pr=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[] colLength=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            colLength[i]=arr[i].length;
            if(colLength[i]>0)
                pr.add(new int[]{arr[i][0],i,0});
        }
        while(--k>0){
            int[] cur=pr.poll();
            if(cur[2]+1<colLength[cur[1]])
                pr.add(new int[]{arr[cur[1]][cur[2]+1],cur[1],cur[2]+1});
        }
        return pr.poll()[0];
    }
}
