package LINTCODE9;

import java.util.HashSet;
import java.util.Stack;

public class LINTCODE834 {
    /*Description
    *给定一个字符串s由小写字符组成，移除多余的字符使得每个字符只出现一次。
    * 你必须保证结果是字典序是最小的合法字符串。
    * */

    /*Solution
    * 用一个栈存储已保留的字符，我们需要让字典序大的字符尽量出现在较后的位置
    * 递归字符，当遇到栈顶元素大于当前元素，且后面仍然存在栈顶元素，则证明栈顶元素需要出栈
    * 持续上述过程直到结束，使当前元素入栈
    * */

    public String removeDuplicateLetters(String s) {
        int[] time=new int[26];  //用一个数组保留每一个字符出现的次数
        for(int i=0;i<s.length();i++){
            time[s.charAt(i)-'a']++;
        }
        HashSet<Character> set=new HashSet<>(); //set用来保存已经保存在栈中的元素
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            time[cur-'a']--;
            if(set.contains(cur))
                continue;
            set.add(cur);
            while(!stack.empty()&&stack.peek()>cur&&time[stack.peek()-'a']>0){
                set.remove(stack.pop());
            }
            stack.push(cur);
        }
        String res="";
        while(!stack.empty())
            res=stack.pop()+res;
        return res;
        // write your code here
    }
}
