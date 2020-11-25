package LINTCODE19;

import java.util.*;

public class LINTCODE1832 {
    /*Description
    * 有一个1 * n1∗n的棋盘，分别标号为0, 1, 2..{n - 1}0,1,2..n−1，棋盘的每个格子都有一种颜色。
    * 现在，在0号位置有一枚棋子，请求出最少移动几步能到达最后一格。
    * 棋子有3种移动的方法，且棋子不能移出到棋盘外：
    * 棋子从位置 i 移动到位置 i+1。
    * 棋子从位置 i 移动到位置 i-1。
    * 如果位置 i 和位置 j 的颜色相同，那么棋子可以直接从位置 i 移动到位置 j。
    * */

    public int minimumStep(List<Integer> colors) {
        int size=colors.size();
        Map<Integer,List<Integer>> map=new HashMap<>();
        Map<Integer,Boolean> colorReached=new HashMap<>();
        for(int i=0;i<size;i++){
            int color=colors.get(i);
            List<Integer> list=map.getOrDefault(color,new ArrayList<>());
            list.add(i);
            map.put(color,list);
            colorReached.put(color,true);
        }
        int[] dp=new int[colors.size()];
        dp[0]=1;
        Queue<Integer> queue=new LinkedList<>();
        int step=1;
        queue.add(0);
        while(!queue.isEmpty()){
            int curSize=queue.size();
            step++;
            while(curSize-->0){
                int cur=queue.poll();
                int curColor=colors.get(cur);
                if(colorReached.get(curColor)) {
                    colorReached.put(curColor,false);
                    List<Integer> list = map.get(colors.get(cur));
                    for (int curr : list) {
                        if(curr==size-1)
                            return step-1;
                        if (dp[curr] > 0)
                            continue;
                        dp[curr] = step;
                        queue.add(curr);
                    }
                }
                if(cur>0&&dp[cur-1]==0){
                    queue.add(cur-1);
                    dp[cur-1]=step;
                }
                if(cur<size-1&&dp[cur+1]==0){
                    if(cur+1==size-1)
                        return step-1;
                    queue.add(cur+1);
                    dp[cur+1]=step;
                }
            }
        }
        return dp[size-1]-1;
        // write your code here
    }
}
