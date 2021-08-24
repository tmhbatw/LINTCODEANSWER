package LINTCODE10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LINTCODE923 {
    /*Description
    * strobogrammatic数是指旋转180度后(朝上看)的数字与原数看起来是相同的。
    * 编写一个函数去计算在low <= num <= high区间内的strobogrammatic数。
    * */

    char[][] next=new char[][]{{'1','1'},{'0','0'},{'6','9'},{'9','6'},{'8','8'}};
    public int strobogrammaticInRange(String low, String high) {
        Queue<String> q=new LinkedList<>();
        q.add("");
        q.add("1");
        q.add("8");
        q.add("0");
        int res=0;
        while(!q.isEmpty()){
            String cur=q.poll();
            if(big(cur,high)>0)
                continue;
            if(big(cur,low)>=0&&cur.charAt(0)!='0') {
                System.out.println(cur);
                res++;
            }
            for(char[] c:next){
                q.add(c[0]+cur+c[1]);
            }
        }
        if(low.equals("0"))
            res++;
        return res;
        // Write your code here
    }

    public int big(String cur, String high){
        if(cur.length()>high.length())
            return 1;
        if(cur.length()<high.length())
            return -1;
        return cur.compareTo(high);
    }

    public static void main(String[] args){
        System.out.println(new LINTCODE923().strobogrammaticInRange("50","100"));

    }
}
