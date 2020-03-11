package LINTCODE19;

public class LINTCODE1846 {
    /*Description
    * 一个机器人位于一对整数坐标（x，y）处。 必须将其移动到具有另一组坐标的位置。
    * 尽管该机器人可以移动任意次，但只能进行以下两种类型的移动：
    * 1.从位置（x，y）到位置（x + y，y）
    * 2.从位置（x，y）到位置（x，x + y）
    * 给定开始和目标结束坐标，如果机器人可以根据给定的运动规则到达结束坐标。 您应该返回True，否则返回False。
    * */

    public boolean ReachingPointsII(int[] start, int[] target) {
        if(start[0]==target[0]&&start[1]==target[1])
            return true;
        if(target[0]<start[0]||target[1]<start[1]||target[0]==target[1])
            return false;
        if(target[0]==start[0]){
            return (target[1] - start[1]) % target[0] == 0;
        }
        if(target[1]==start[1]){
            return (target[0]-start[0])%target[1]==0;
        }
        if(target[0]>target[1])
            return ReachingPointsII(start,new int[]{target[0]%target[1],target[1]});
        return ReachingPointsII(start,new int[]{target[0],target[1]%target[0]});
        // write your code here
    }
}
