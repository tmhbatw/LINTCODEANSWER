package LINTCODE9;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE890 {
    /*Description
    * 一个字符串 "word" 可以有以下的缩写方式:
    * ["word","1ord","w1rd","wo1d","wor1","2rd","w2d","wo2",
    * "1o1d","1or1","w1r1","1o2","2r1","3d","w3","4"]
    * 给定一个目标字符串，和一个字符串集合的字典，找到一个这个字符串的最小可能长度的缩写，
    * 这个缩写不可以与字典中其他字符串的缩写冲突。
    * 假定缩写中的每个数字或字母的长度为1。例如，缩写"a32bc"的长度为5。
    * */

    public String minAbbreviation(String target, String[] dictionary) {
        List<String> list=new ArrayList<>();
        dfs(target,0,new StringBuilder(),true,list);
        for(String cur:dictionary){
            if(cur.length()==target.length()){
                List<String> l=new ArrayList<>();
                dfs(cur,0,new StringBuilder(),true,l);
                list.removeAll(l);
            }
        }
        int length=Integer.MAX_VALUE;
        String result="";
        for(String res:list){
            if(res.length()<length){
                length=res.length();
                result=res;
            }
        }
        return result;
        // Write your code here
    }

    private void dfs(String target, int index, StringBuilder cur, boolean isNumber,List<String> list){
        if(index==target.length()){
            list.add(cur.toString());
            return;
        }
        if(isNumber){
            for(int i=2;i<=target.length()-index;i++){
                StringBuilder curr=new StringBuilder(cur);
                curr.append(i);
                dfs(target,index+i,curr,false,list);
            }
        }
        cur.append(target.charAt(index));
        dfs(target,index+1,cur,true,list);
    }



    public static void main(String[] args){
        String test="word";
        List<String> list=new ArrayList<>();
        new LINTCODE890().dfs(test,0,new StringBuilder(),true,list);
        System.out.println(list);
    }
}
