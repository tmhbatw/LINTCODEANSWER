package LINTCODE14;

public class LINTCODE1300 {
    /*Description
    * 你正在和朋友进行Nim博弈：桌子上有一堆石头，每一次你们都会从中拿出1到3个石头。拿走最后一个石头的人赢得博弈。博弈开始时，你是先手。
    * 假设两个人都绝对理性，都会做出最优决策。给定石头的数量，判断你是否会赢得比赛。
    * 举例：有四个石头，那么你永远不会赢得比赛。不管拿几个，最后一个石头一定会被你的朋友拿走
    * */
    /*Solution
    * 与对手凑四
    * 当开始为4的倍数则必输，其他必赢
    * */

    public boolean canWinNim(int n) {
        return n%4!=0;
        // Write your code here
    }
}
