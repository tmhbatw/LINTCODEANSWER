package LINTCODE7;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE624 {
    /*Description
    * 给出一个字符串 s 以及 n 个子串。你可以从字符串 s 中移除 n 个子串中的任意一个，
    * 使得剩下来s的长度最小，输出这个最小长度。
    * */

    public int minLength(String s, Set<String> dict) {
        int res=s.length();
        Set<String> set=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(s);
        set.add(s);
        while(!q.isEmpty()){
            String cur=q.poll();
            for(String curr:dict){
                int found=-1;
                while(cur.indexOf(curr,found)!=-1){
                    found=cur.indexOf(curr,found);
                    String curS=cur.substring(0,found)+cur.substring(found+curr.length());
                    if(set.contains(curS))
                        continue;
                    set.add(curS);
                    res=Math.min(res,curS.length());
                    q.add(curS);
                }
            }
        }
        return res;
        // write your code here
    }
}
