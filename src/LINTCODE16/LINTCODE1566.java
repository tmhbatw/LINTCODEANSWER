package LINTCODE16;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1566 {
    /*Description
    * 给出一个 n * m 的二维数组，数组每一行的元素都是排序的，每一行选择 1 个数，总共选择 n 个数，
    * 这 n 个数的 diff 为 maximum-minimum，求最小的diff
    * */


    public int minimumDifference(int[][] array) {
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int result=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++) {
            q.add(new int[]{array[i][0], i,0});
            max=Math.max(array[i][0],max);
        }
        while(true){
            int[] cur= q.poll();
            result=Math.min(result,max-cur[0]);
            if(cur[2]==array[cur[1]].length-1)
                break;
            max=Math.max(array[cur[1]][cur[2]+1],max);
            q.add(new int[]{array[cur[1]][cur[2]+1],cur[1],cur[2]+1});
        }
        return result;
        // Write your code here
    }
}
