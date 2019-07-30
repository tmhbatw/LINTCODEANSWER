package LINTCODE6;

import java.util.*;

public class LINTCODE582 {

    /*Description
    *给一字串s和单词的字典dict,在字串中增加空格来构建一个句子，并且所有单词都来自字典。
    * 返回所有有可能的句子。
    * */


    public List<String> wordBreak(String s, Set<String> wordDict) {
        //添加一点小小的过滤机制
        boolean[] string=new boolean[128];
        for(int i=0;i<s.length();i++){
            string[s.charAt(i)]=true;
        }
        boolean[] dic=new boolean[128];
        int maxLength=0;
        for(String cur:wordDict) {
            for(int i=0;i<cur.length();i++){
                dic[cur.charAt(i)]=true;
            }
            maxLength = Math.max(maxLength, cur.length());
        }
        for(int i=0;i<128;i++){
            if(string[i]&&!dic[i])
                return Collections.emptyList();
        }
        List<String> res=new ArrayList<>();
        recursion(res,"",s,maxLength,wordDict);
        return res;
        // write your code here
    }

    private void recursion(List<String> result,String res,String last,int maxLength,Set<String> wordDict){
        if(last.length()==0){
            result.add(res.substring(0,res.length()-1));
            return;
        }
        for(int i=0;i<last.length()&&i<maxLength;i++){
            String cur=last.substring(0,i+1);
            if(wordDict.contains(cur)){
                recursion(result,res+cur+" ",last.substring(i+1,last.length()),maxLength,wordDict);
            }
        }

    }

    public static void main(String[] args){
        String a="abc";
        String b=a.substring(a.length(),a.length());
        System.out.println(b.length());
    }
}
