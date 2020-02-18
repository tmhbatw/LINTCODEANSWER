package LINTCODE11;

import java.util.Stack;

public class LINTCODE1060 {
    /*Description
    * 给定一个每日temperatures的列表，产生一个列表，对于输入的每天，告诉我们你要等多少天才能够等到一个更高的温度。如果没有可能的未来日期，输出0作为替代。
    * 比如，给定列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
    * */

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack=new Stack<>();
        int[] result=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.empty()&&stack.peek()[0]<temperatures[i]){
                int index=stack.pop()[1];
                result[index]=i-index;
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return result;
        // Write your code here
    }
}
