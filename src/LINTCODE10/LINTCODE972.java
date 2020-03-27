package LINTCODE10;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE972 {
    /*Description
    * 给一个公司的人员信息，第i个人传递消息的时间花费为t[i]，下属名单为list[i]，当某人接到消息后他会马上传递给他的所有下属。
    * 0号人物是CEO。现在CEO发布了一个消息传递下去，问公司里面所有人都收到消息的时间是多少？
    * */

    public int deliverMessage(int[] t, int[][] subordinate) {
        int[] dp=new int[t.length];
        Queue<Integer> queue=new LinkedList<>();
        dp[0]=t[0];
        queue.add(0);
        while(!queue.isEmpty()){
            int cur=queue.poll();
            int[] list=subordinate[cur];
            if(list[0]!=-1){
                int time=t[cur];
                for(int curNumber:list) {
                    dp[curNumber] = dp[cur] + time;
                    queue.add(curNumber);
                }
            }
        }
        int result=0;
        for(int num:dp)
            result=Math.max(result,num);
        return result;
        // Write your code here
    }
}
