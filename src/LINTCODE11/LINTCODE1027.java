package LINTCODE11;

public class LINTCODE1027 {
    /*Description
    * 你正在玩一个简单版的吃豆人游戏。起初你在点(0, 0)，你的目的地是 (target[0], target[1])。 在地图上有几个幽灵，第i个幽灵起初在 (ghosts[i][0], ghosts[i][1])。
    * 在每一轮中，你和幽灵可以同时向东南西北这四个方向之一移动一个单位距离。
    * 当且仅当你能够在任何幽灵碰到你之前（幽灵可能以任意的路径移动）到达终点时，你能够成功逃脱。如果你和幽灵同时到达某一个位置（包括终点），这一场游戏记为逃脱失败。
    * 如果你可以成功逃脱，返回true，否则返回false。
    * */

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance=Math.abs(target[0])+Math.abs(target[1]);
        for(int[] cur:ghosts){
            if(distance>=Math.abs(target[0]-cur[0])+Math.abs(target[1]-cur[1]))
                return false;
        }
        return true;
        // write your code here
    }
}
