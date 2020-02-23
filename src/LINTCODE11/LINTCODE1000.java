package LINTCODE11;

public class LINTCODE1000 {
    /*Description
    * 给定一个数组，其中第i个元素是一支股票在第i天的价格，以及一个非负数 fee 代表了交易手续费。（只需要在卖出时支付 fee）
    * 你可以进行任意次交易，而每次交易都必须付手续费，而且你不能持有超过1支数量的股票（也就是说，你在买入之前需要先把之前买入的卖出）。
    * 返回可以获得的最大利润。
    * */

    public int maxProfit(int[] prices, int fee) {
        int sell=0;
        int own=prices[0];
        for(int num :prices){
            sell=Math.max(sell,num+own-fee);
            own=Math.max(own,sell-num);
        }
        return sell;
    }
}
