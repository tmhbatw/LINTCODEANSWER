package LINTCODE7;

import java.util.*;

public class LINTCODE643 {
    /*Description
    * 最长绝对文件路径
     * */

    public int lengthLongestPath(String input) {
        if(input.length()==0)
            return 0;
        Stack<int[]> q=new Stack<>();
        int result=0;
        String[] file=input.split("\n");
        for(String cur:file){
            int layer=0;
            while(cur.charAt(0)=='\t') {
                layer++;
                cur=cur.substring(1);
            }
            while(!q.isEmpty()&&q.peek()[0]>=layer)
                q.pop();
            int curLength=(q.isEmpty()?0:q.peek()[1])+cur.length();
            if(cur.contains("."))
                result=Math.max(result,curLength+layer);
            q.add(new int[]{layer,curLength});
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
        Date now =new Date();
        System.out.println(now.toString());
    }
}
