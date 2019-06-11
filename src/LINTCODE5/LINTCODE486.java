package LINTCODE5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE486 {
    /*Description
    *将 k 个有序数组合并为一个大的有序数组。
    * Challenge
    * 在 O(N log k) 的时间复杂度内完成：
    * */

    /*Solution
    * 因为题目要求在O（N log k)时间复杂内完成，那么想到了用小根堆
    * 将每一个数组保存在一个对象中，对象中另存储一个index下标，表示当前这个数组遍历到了哪一位
    * */

    public int[] mergekSortedArrays(int[][] arrays) {
        int number=0;
        PriorityQueue<Counter> queue=new PriorityQueue<>(new Comparator<Counter>() {
            @Override
            public int compare(Counter o1, Counter o2) {
                return o1.arrays[o1.index]-o2.arrays[o2.index];
            }
        });
        for(int i=0;i<arrays.length;i++){
            number+=arrays[i].length;
            if(arrays.length>0)
                queue.add(new Counter(arrays[i],0));
        }
        int[] result=new int[number];
        int index=0;
        while(!queue.isEmpty()){
            Counter curr=queue.poll();
            result[index++]=curr.arrays[curr.index];
            curr.index++;
            if(curr.index<curr.arrays.length)
                queue.add(curr);
        }
        return result;
        // write your code here
    }

    class Counter{
        int index=0;
        int[] arrays;
        public Counter(int[] arrays,int index){
            this.arrays=arrays;
            this.index=index;
        }
    }
}
