package LINTCODE20;

import java.util.List;

public class LINTCODE1916 {
    /*Description
    * 有一排 26 个彩灯，编号从 0 到 25，现在给出了一系列控制指令来控制这些彩灯的开关。
    * 一开始这些彩灯都是关闭的，然后指令将逐条发出。
    * 在每条指令operation[i]中含有两个整数 operation[i][0], operation[i][1]。
    * 在接收到一条指令时，标号为 operation[i][0] 的彩灯会亮起，直到第 operation[i][1] 秒的时候熄灭。
    * 当灯熄灭后，下一条指令将会发出。
    * 其中第一条指令将在第0秒的时候发出，并被立刻执行。
    * 你的任务是找到哪个彩灯单次亮起的时间最长。
    * 例如：operation = [[0, 2], [1, 5], [0, 9], [2, 15]]
    * 在第0秒的时候，接收到指令[0, 2]，此时标号为 0 的灯亮起，第 2 秒的时候熄灭。此时 0号灯 的单次亮起时间为2-0 = 2 秒。
    * 在第2秒的时候，接收到指令[1, 5]，此时标号为 1 的灯亮起，第 5 秒的时候熄灭。此时 1号灯 的单次亮起时间为 5-2 = 3 秒。
    * 在第5秒的时候，接收到指令[0, 9]，此时标号为 0 的灯亮起，第 9 秒的时候熄灭。此时 0号灯 的单次亮起时间为 9-5 = 4 秒。
    * 在第9秒的时候，接收到指令[2, 15]，此时标号为 2 的灯亮起，第 15 秒的时候熄灭。此时 2号灯 的单次亮起时间为 15-9 = 6 秒。
    * 所以单次亮起的最长时间为 max(2, 3, 4, 6) = 6 秒，是标号为 2 的彩灯。
    * 你需要返回一个小写英文字母代表这个编号。如 'a' 代表 0，'b' 代表 1，'c' 代表 2 ... 'z' 代表 25。
    * 所以你的答案应该是'c'
    * */

    public char longestLightingTime(List<List<Integer>> operation) {
        int result=-1;
        int maxTime=0;
        int pre=0;
        for(List<Integer> list:operation){
            int curTime=list.get(1)-pre;
            pre=list.get(1);
            if(curTime>maxTime){
                maxTime=curTime;
                result=list.get(0);
            }
        }
        return (char)(result+'a');
        // write your code here
    }
}
