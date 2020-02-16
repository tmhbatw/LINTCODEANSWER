package LINTCODE13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE1252 {
    /*Description
    * 假设你有一个顺序被随机打乱的列表，代表了站成一列的人群。每个人被表示成一个二元组(h, k)，
    * 其中h表示他的身高，k表示站在他之前的身高高于或等于h的人数。你需要将这个队列重新排列以恢复其原有的顺序。
    * */

    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        for(int[] cur:people)
            queue.add(cur);
        List<int[]> res=new ArrayList<>();
        while(!queue.isEmpty()) {
            int[] cur=queue.poll();
            res.add(cur[1], cur);
        }
        int[][] result=new int[people.length][2];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
        // write your code here
    }
}
