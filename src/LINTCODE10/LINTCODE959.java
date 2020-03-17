package LINTCODE10;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE959 {
    /*Description
    * 一个数组每隔k个数字是从小到大有序的，即arr[i] <= arr[i + k] <= arr[i + 2 * k] <= ....，
    * 请将这个数组从小到大排序。我们期望你能写出** O(n * logk)** 复杂度的算法。
    * */

    public int[] getSortedArray(int[] arr, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int length=arr.length;
        for(int i=0;i<k;i++)
            queue.add(new int[]{arr[i],i});
        int[] result=new int[length];
        int index=0;
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            result[index++]=cur[0];
            cur[1]+=k;
            if(cur[1]<length) {
                cur[0]=arr[cur[1]];
                queue.add(cur);
            }
        }
        return result;
        // Write your code here
    }
}
