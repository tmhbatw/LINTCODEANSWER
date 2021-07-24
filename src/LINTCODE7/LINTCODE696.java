package LINTCODE7;

import java.util.*;

public class LINTCODE696 {

    /*Description
    * 这里有 n 门不同的线上课程, 编号为 1 到 n. 每一节课都有持续时间(课程长度) t 和 在第 d 天关闭.
    * \课程应连续持续 t 天，必须在第d天或之前完成, 你将从第一天开始.
    * 给出 n 门线上课程用 pairs (t, d) 来表示, 你的任务是找到可以上的最大数量的课程数.
    * */
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
        int count =0;
        int time = 0;
        Arrays.sort(courses,(o1,o2)->{
            return o1[1]-o2[1];
        });
        for(int[] cur:courses){
            if(cur[0]>cur[1])
                continue;
            if(time+cur[0]<=cur[1]){
                count++;
                time+=cur[0];
            }else{
                if(q.isEmpty()||cur[0]>=q.peek())
                    continue;
                int replaceValue = q.poll();
                time -= replaceValue-cur[0];
            }
            q.add(cur[0]);
        }
        return count;
        // write your code here
    }
}
