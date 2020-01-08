package LINTCODE9;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE846 {
    /*Description
    * 多关键字排序
    * 给定 n 个学生的学号(从 1 到 n 编号)以及他们的考试成绩，表示为(学号，考试成绩)，请将这些学生按考试成绩降序排序，若考试成绩相同，则按学号升序排序。
    * */

    /*Solution
    * 创建最小堆重写排序构造方法即可
    * */

    public int[][] multiSort(int[][] array) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o2[1]-o1[1];
            }
        });
        Collections.addAll(queue, array);
        int[][] res=new int[array.length][2];
        for(int i=0;i<res.length;i++){
            res[i]=queue.poll();
        }
        return res;
        // Write your code here
    }

}
