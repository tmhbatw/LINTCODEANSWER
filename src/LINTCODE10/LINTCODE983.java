package LINTCODE10;

import java.util.Stack;

public class LINTCODE983 {
    /*Description
    *现在你是棒球比赛分记录员。
    * 给定一个字符串数组，每一个字符串可以是以下4种中的其中一个：
    * 整数 (一个回合的分数): 直接表示这回合你得到的分数。
    * "+" (一个回合的分数): 表示这回合你获得的分数为前两个 有效 分数之和。
    * "D" (一个回合的分数): 表示这回合你得到的分数为你上一次获得的有效分数的两倍。
    * "C" (一种操作，而非一个回合的分数): 表示你上回合的有效分数是无效的，需要移除。
    * 每一轮的操作都是永久性的，可能会影响之前和之后的一轮。
    * 你需要返回在所有回合中获得总分数。
    * */

    public int calPoints(String[] ops) {
        int res=0;
        Stack<Integer> stack=new Stack<>();
        for(String cur:ops){
            if(cur.equals("+")){
                int score1=stack.pop();
                int score2=stack.pop();
                int curSum=score1+score2;
                stack.add(score2);
                stack.add(score1);
                stack.add(curSum);
                res+=curSum;
            }else if(cur.equals("D")){
                int score=stack.peek()*2;
                res+=score;
                stack.add(score);
            }else if(cur.equals("C")){
                int score=stack.pop();
                res-=score;
            }else{
                int score=Integer.parseInt(cur);
                stack.add(score);
                res+=score;
            }
        }
        return res;
        // Write your code here
    }
}
