package LINTCODE7;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LINTCODE696 {

    /*Description
    * 这里有 n 门不同的线上课程, 编号为 1 到 n. 每一节课都有持续时间(课程长度) t 和 在第 d 天关闭. 课程应连续持续 t 天，必须在第d天或之前完成, 你将从第一天开始.
    * 给出 n 门线上课程用 pairs (t, d) 来表示, 你的任务是找到可以上的最大数量的课程数.
    * */
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        System.out.println(new Integer(3));
        for(int[] cur:courses){
            queue.add(cur);
        }
        int start=0;
        int num=0;
        Queue<int[]> res=new LinkedList<>();

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            if(cur[0]+start<=cur[1]){
                start+=cur[0];
                num++;
            }
        }
        return num;
        // write your code here
    }
}
