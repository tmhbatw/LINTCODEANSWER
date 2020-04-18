package LINTCODE16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1538 {
    /*Description
    *你跟你的朋友在玩一个卡牌游戏，总共有 n 张牌。每张牌的成本为 cost[i] 并且可以对对手造成 damage[i] 的伤害。
    * 你总共有 totalMoney 元并且需要造成至少 totalDamage 的伤害才能获胜。每张牌只能使用一次，判断你是否可以取得胜利。
    * */

    public boolean cardGame(int[] cost, int[] damage, int totalMoney, int totalDamage) {
        int cardNumber=cost.length;
        int[] dp=new int[totalMoney+1];
        for(int i=0;i<cardNumber;i++){
            int curCost=cost[i];
            int curDamage=damage[i];
            for(int j=totalMoney;j>=0;j--){
                if(j<curCost)
                    break;
                dp[j]=Math.max(dp[j],dp[j-curCost]+curDamage);
            }
        }
        return dp[totalMoney]>=totalDamage;
        // Write your code here
    }
}
