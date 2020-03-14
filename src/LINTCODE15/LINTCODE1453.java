package LINTCODE15;

public class LINTCODE1453 {
    /*Description
    * 给一个数组 price 是所有要买的东西的价格，买当前东西的折扣是之前买过的东西里最便宜的价格，如果折扣大于价格的话就免费，
    * 折扣小于价格的话只需要支付当前价格减去折扣价格的费用。返回买下这些东西的最小花费。
    * */

    public int MinimumAmount(int[] price) {
        if(price.length==0)
            return 0;
        int result=price[0];
        int preMin=price[0];
        for(int i=1;i<price.length;i++){
            if(preMin>price[i])
                preMin=price[i];
            else
                result+=price[i]-preMin;
        }
        return result;
        // write your code here
    }
}
