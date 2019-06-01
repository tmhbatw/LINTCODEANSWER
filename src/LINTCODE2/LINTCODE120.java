package LINTCODE2;

import java.util.*;

public class LINTCODE120 {
    /*Description
    * 给出两个单词（start和end）和一个字典，找出从start到end的最短转换序列，输出最短序列的长度。
    * 变换规则如下：
    * 每次只能改变一个字母。
    * 变换过程中的中间单词必须在字典中出现。(起始单词和结束单词不需要出现在字典中)
    * */

    /*Solution
    *宽度优先遍历
    * 将当前字符串能到达的字符串全部输出并保存起来，队列中去掉当前字符串
    * 对数据结构中的全部字符串做相同操作，知道找到目标字符串位置
    * 需要注意的是输出的字符串在原集合中全部删去
    * */


    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        List<String> list=new ArrayList<>();
        for(String res:dict)
            list.add(res);
        Deque<String> stack=new ArrayDeque<>();
        stack.add(start);
        int step=1;
        while(!stack.isEmpty()){
            step++;
            int size=stack.size();
            for(;size>0;size--){
                String cur=stack.pollLast();
                for(int i=list.size()-1;i>=0;i--){
                    String curr=list.get(i);
                    if(change(curr,cur)) {
                        if(curr.equals(end))
                            return step;
                        stack.push(curr);
                        list.remove(curr);
                    }
                }
            }
        }
        return step;
        // write your code here
    }

    private boolean change(String curr,String s){
        int result=0;
        for(int i=0;i<curr.length();i++){
            if(result==2)
                return false;
            if(curr.charAt(i)!=s.charAt(i)) {
                result++;
            }
        }
        return result==1;
    }



}
