package LINTCODE8;

public class LINTCODE797 {
    /*Description
    *你站在一个无穷数轴上的 0 位置。在位置目标上有一个目标。
    * 在每一个动作中，你可以向左或向右。在第n次移动中(从1开始)，你行走n步。
    * 返回到达目的地所需的最小步骤数。
    * */

    public int reachNumber(int target) {
        target=Math.abs(target);
        int index=0;
        int sum=0;
        while(sum<target){
            sum+=++index;
        }
        if((sum-target)%2==0)
            return index;
        if((sum-target+index+1)%2==0)
            return index+1;
        return index+2;
        // Write your code here
    }
}
