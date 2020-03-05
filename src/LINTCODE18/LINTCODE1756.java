package LINTCODE18;

public class LINTCODE1756 {
    /*Description
    * 一天小明出去买饮料，小明手里有budget元钱。他到了商店之后发现，商店所卖的饮料在搞活动。
    * 饮料cost元一个，每一瓶饮料送一个积分，每exchange个积分可以换一瓶饮料。
    * 输出小明用手中budget元钱最多可以买到多少瓶饮料
    * */

    public int buyBeverage(int budget, int cost, int exchange) {
        int beverage=budget/cost;
        int result=beverage;
        while(beverage>=exchange){
            int cur=beverage/exchange;
            result+=cur;
            beverage=cur+beverage-cur*exchange;
        }
        return result;
        // write your code here
    }
}
