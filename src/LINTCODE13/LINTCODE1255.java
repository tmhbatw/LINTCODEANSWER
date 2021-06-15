package LINTCODE13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LINTCODE1255 {
    /*Description
    * 给定一个以字符串表示的非负整数，从该数字中移除掉k个数位，
    * 让剩余数位组成的数字尽可能小，求可能的最小结果。
    * */

    public String removeKdigits(String num, int k) {
        Deque<Character> dq=new ArrayDeque<>();
        int idx=0;
        for(;idx<num.length();idx++){
            if(k==0)
                break;
            char cur=num.charAt(idx);
            while(k>0&&!dq.isEmpty()&&dq.peekLast()>cur){
                k--;
                dq.pollLast();
            }
            dq.add(cur);
        }
        StringBuilder sb=new StringBuilder();
        if(k>0){
            int size=dq.size()-k;
            while(size-->0)
                sb.append(dq.pollFirst());
        }else{
            while(!dq.isEmpty())
                sb.append(dq.pollFirst());
            for(int i=idx;i< num.length();i++)
                sb.append(sb.charAt(i));
        }
        int i=0;
        while(i<sb.length()&&sb.charAt(i)=='0')
            i++;
        return i==sb.length()?"0":sb.substring(i);
        // write your code here
    }
}
