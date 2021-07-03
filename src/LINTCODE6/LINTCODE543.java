package LINTCODE6;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LINTCODE543 {
    /*Description
    * 在N个数组中找到第K大元素
    * */

    public int KthInArrays(int[][] arrays, int k) {
        for(int[] cur: arrays) {
            Arrays.sort(cur);
            for(int i=0;i<cur.length/2;i++){
                int temp=cur[i];
                cur[i]=cur[cur.length-1-i];
                cur[cur.length-1-i]=temp;
            }
        }
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o2[0]-o1[0];
        });
        for(int i=0;i<arrays.length;i++){
            if(arrays[i].length==0)
                continue;
            q.add(new int[]{arrays[i][0],i,0});
        }
        while(--k>0){
            int[] cur=q.poll();
            if(arrays[cur[1]].length>cur[2]+1)
                q.add(new int[]{arrays[cur[1]][cur[2]+1],cur[1],cur[2]+1});
        }
        return q.poll()[0];
        // write your code here
    }
}
