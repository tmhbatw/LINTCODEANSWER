package LINTCODE10;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE965 {
    /*Description
    * 给出两个只有 'l', 'r' 的字符串s 和t，以及一个整数n。
    * 请求出能否按照以下规则，将s 转换成t，如果能，返回真，否则返回假。
    * 'l' 字符只能向左移动（与它左边的字符交换位置），'r' 只能往右移（与它右边的字符交换位置）。
    * 'l' 和 'r' 字符相互交换的最大次数为n
    * */

    public boolean LRString(String s, String t, int n) {
        if(s.length()!=t.length())
            return false;
        int sLeftTime=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='l')
                sLeftTime++;
            else
                sLeftTime--;
        }
        int tLeftTime=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='l')
                tLeftTime++;
            else
                tLeftTime--;
        }
        if(sLeftTime!=tLeftTime)
            return false;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='l')
                q.add(i);
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='l'){
                int cur=q.poll();
                if(cur<i)
                    return false;
                else
                    n-=cur-i;
            }
            if(n<0)
                return false;
        }
        return true;
        // write your code here.
    }
}
