package LINTCODE2;

public class LINTCODE149 {
    /*Description
    *  Best Time to Buy and Sell Stock
    * Say you have an array for which the ith element is the price of a given stock on day i.
    * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    * */

    /*Solution
    *一次遍历，保留最小结果以及当前数字之前的最小数
    * 结果与当前数与最小数的差两者的最大值即为新的result
    * 返回结果值即可
    * */

    public int maxProfit(int[] prices) {
        int result=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            result=Math.max(prices[i]-min,result);
            min=Math.min(min,prices[i]);
        }
        return result;
        // write your code here
    }
}
