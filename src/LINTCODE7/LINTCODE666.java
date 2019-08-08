package LINTCODE7;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE666 {
    /*Description
    * 我们正在玩猜数游戏, 游戏内容如下:
    * 我在 1到 n 的范围内选择一个数作为待猜的数, 你需要来猜这个数。
    * 每次你猜错的时候, 我会告诉你我选择的这个数是比你说的数要高还是低。
    * 但是, 当你猜这个数为 x 并且猜错的时候你需要支付 $x. 当你猜到我选择的数时, 你将赢得这场游戏。
    * 给一个具体的大于等于 1 的数 n, 计算你需要多少钱才可以保证赢
    * */

    /*Solution
    *数组所占内存要小于hashmap
    * */

    int[][] num;
    public int getMoneyAmount(int n) {
        num=new int[n][n];
        int max=recursion(1,n);
        return max;
        // write your code here
    }

    private int recursion(int start,int end){
        if(start>=end)
            return 0;
        if(num[start-1][end-1]!=0)
            return num[start-1][end-1];
        int cur=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            cur=Math.min(cur,Math.max(recursion(start,i-1),recursion(i+1,end))+i);
        }
        num[start-1][end-1]=cur;
        return cur;
    }
}
