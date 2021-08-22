package LINTCODE8;

import java.util.*;

public class LINTCODE796 {
    /*Description
    * 你面前有一个有四个圆形轮子的锁。每个轮子有10个槽:‘0’,‘1’,‘2’,‘3’,‘4’,‘5’,‘6’,‘7’,‘8’,‘9’。
    * 轮子可以自由旋转并环绕:例如，我们可以把‘9’变成‘0’，或者‘0’变成‘9’。每个动作包括转动一个轮子一个槽。
    * 锁最初是‘0000’开始的，这是一个表示四个轮子状态的字符串。
    * 你被给了一个死锁的列表，意思是如果锁显示了这些代码中的任何一个，锁的轮子将停止转动，你将无法打开它。
    * 给定一个表示将解锁锁的轮子的值的目标，返回打开锁所需要的最小总次数，如果不可能，则返回-1。
    * */

    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>();
        for(String cur:deadends){
            set.add(cur);
        }
        if(set.contains("0000"))
            return -1;
        set.add("0000");
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur = q.poll();
                String[] next=getString(cur);
                for(String n:next){
                    if(!set.contains(n)){
                        if(target.equals(n))
                            return distance;
                        set.add(n);
                        q.add(n);
                    }
                }
            }
            distance++;
        }
        return -1;
        // Write your code here
    }

    private String[] getString(String cur){
        String[] res=new String[8];
        for(int j=0;j<4;j++){
            res[j*2]=cur.substring(0,j)+add(cur.charAt(j))+cur.substring(j+1);
            res[j*2+1]=cur.substring(0,j)+delete(cur.charAt(j))+cur.substring(j+1);
        }
        return res;
    }

    private char add(char cur){
        if(cur=='9')
            return '0';
        return (char)(cur+1);
    }

    private char delete(char cur){
        if(cur=='0')
            return '9';
        return (char)(cur-1);
    }

    public static void main(String[] args){
        String start="0000";
        System.out.println(Arrays.toString(new LINTCODE796().getString(start)));
    }
}
