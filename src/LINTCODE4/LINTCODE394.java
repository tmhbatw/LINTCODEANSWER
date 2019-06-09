package LINTCODE4;

public class LINTCODE394 {

    /*Description
    * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。拿到最后一枚硬币的人获胜。
    * 请判定 先手玩家 必胜还是必败?
    * 若必胜, 返回 true, 否则返回 false.
    * */

    /*Solution
    * 这是一个有趣的数学问题；
    * 当先手玩家拿走1个或两个，此时硬币堆变成3的倍数时，不管后手玩家拿一个或两个，先手玩家可以拿走两个或一个促成三
    * 那么先手玩家一定可以拿走最后一个硬币
    * 当硬币堆是三的倍数时，则一定是后手玩家赢
    * */

    public boolean firstWillWin(int n) {
        return n%3!=0;
        // write your code here
    }
}
