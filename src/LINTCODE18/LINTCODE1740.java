package LINTCODE18;

import java.util.Stack;

public class LINTCODE1740 {
    /*Description
    *编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
    * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
    * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
    * */

    class StockSpanner {
        Stack<int[]> stack;
        public StockSpanner() {
            stack=new Stack<>();
        }
        /**
         * @param price:
         * @return: int
         */
        public int next(int price) {
            int res=1;
            while(!stack.empty()&&price>=stack.peek()[0]){
                res+=stack.pop()[1];
            }
            stack.push(new int[]{price,res});
            return res;
            // Write your code here.
        }
    }
}
