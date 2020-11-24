package LINTCODE19;

public class LINTCODE1836 {
    /*Description
    * 一个机器人位于一对整数坐标（x，y）处。 必须将其移动到具有另一组坐标的位置。 尽管该机器人可以移动任意次，但只能进行以下两种类型的移动：
    * 1.从位置（x，y）到位置（x + y，y）
    * 2.从位置（x，y）到位置（x，x + y）
    * 给定开始和目标结束坐标，如果机器人可以根据给定的运动规则到达结束坐标。 您应该返回True，否则返回False。
    * */

    public boolean ReachingPoints(int[] start, int[] target) {
        return recursion(target[0],target[1],start[0],start[1]);
        // write your code here
    }

    private boolean recursion(int x,int y,int targetX,int targetY){
        if(x<targetX||y<targetY)
            return false;
        if(x<=y){
            if(x==targetX)
                return (y-targetY)%x==0;
            return recursion(x,y%x,targetX,targetY);
        }
        if(y==targetY)
            return (x-targetX)%y==0;
        return recursion(x%y,y,targetX,targetY);
    }
}
