package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1147 {
    /*Description
    * 小美是团队的负责人，需要为团队制定工作的计划，来帮助团队产生最大的价值。每周团队都会有两项候选的任务,
    * 其中一项为简单任务,一项为复杂任务,两项任务都能在一周内完成。在第i周,团队完成简单任务的价值为low_i,完成复杂任务的价值为high_i。
    * 由于复杂任务本身的技术难度较高，团队如果在第i周选择执行复杂任务的话,需要在i-1周不做任何任务来专心准备。
    * 如果团队在第i周选择执行简单任务的话,不需要提前做任何准备。现在小美的团队收到了未来n周的候选任务列表,请帮助小美确定每周的工作安排使得团队的工作价值最大。
    * */

    public int workPlan(int[] low, int[] high) {
        int days=low.length;
        int[] result=new int[days+1];
        result[1]=low[0];
        for(int i=1;i<days;i++){
            result[i+1]=Math.max(result[i]+low[i],result[i-1]+high[i]);
        }
        System.out.println(Arrays.toString(result));
        return result[days+1];
        // Write your code here.
    }
}
