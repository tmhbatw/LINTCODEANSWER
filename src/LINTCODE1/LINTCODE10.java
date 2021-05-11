package LINTCODE1;

import java.util.*;

public class LINTCODE10 {

    /*Description
    * 给出一个字符串，找到它的所有排列，注意同一个字符串不要打印两次。
    * */

    /*Solution
    * 解题思路：递归回溯算法，并注意去重复
    * （PS：递归回溯算法适用于大部分题型）
    * */

    boolean[] reached;
    char[] s;
    List<String> result;
    public List<String> stringPermutation2(String str) {
        s=str.toCharArray();
        Arrays.sort(s);
        reached=new boolean[str.length()];
        result=new ArrayList<>();
        dfs(0,"");
        return result;
        // write your code here
    }

    private void dfs(int n,String cur){
        int length=s.length;
        if(n==length){
            result.add(cur);
            return;
        }
        for(int i=0;i<length;i++){
            if(reached[i])
                continue;
            cur+=s[i];
            int start=i;
            while(i<length-1&&s[i+1]==s[i])
                i++;
            reached[start]=true;
            dfs(n+1,cur);
            reached[start]=false;
            cur=cur.substring(0,cur.length()-1);
        }
    }


    //一年前的方法
/*    public List<String> stringPermutation2(String str) {
        Set<String> result=new HashSet<>();
        int length=str.length();
        boolean[] reached=new boolean[length];
        StringBuilder res=new StringBuilder();
        recursion(result,reached,str,res,length,length);
        return new ArrayList<>(result);
        // write your code here
    }

    //递归方法
    private void recursion(Set<String> result,boolean[] reached,String str,StringBuilder res,int n,int length){
        if(n==0){
            result.add(res.toString());
            return;
        }
        for(int i=0;i<length;i++){
            if(reached[i])
                continue;
            StringBuilder cur=new StringBuilder(res);
            cur.append(str.charAt(i));
            boolean[] curReached= reached.clone();
            curReached[i]=true;
            recursion(result,curReached,str,cur,n-1,length);
        }

    }
    private String removeChar(String str,int i){
        return str.substring(0,i)+str.substring(i+1,str.length());
    }*/
}
