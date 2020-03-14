package LINTCODE19;

import java.util.Stack;

public class LINTCODE1852 {
    /*Description
    * 一位店主需要完成一项销售任务，他将要出售的物品排成一排。
    * 从左侧开始，店主以其全价减去位于该物品右侧的第一个价格较低或价格相同的商品的价格。
    * 如果右侧没有价格低于或等于当前商品价格的商品，则以全价出售当前商品。
    * 你需要返回每一个物品实际售出价格。
    * */

    public int[] FinalDiscountedPrice(int[] prices) {
        int length=prices.length;
        if(length==0)
            return prices;
        int[] result=new int[length];
        result[length-1]=prices[length-1];
        Stack<Integer> stack=new Stack<>();
        stack.push(prices[length-1]);
        for(int j=length-2;j>=0;j--){
            while(!stack.isEmpty()&&stack.peek()>prices[j])
                stack.pop();
            int cur=stack.isEmpty()?0:stack.peek();
            result[j]=prices[j]-cur;
            stack.push(prices[j]);
        }
        return result;
        // write your code here
    }
}
