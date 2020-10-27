package LINTCODE3;

import java.util.*;

public class LINTCODE257 {
    /*Description
    * 给出一个单词列表，其中每个单词都由小写英文字母组成。
    * 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac" 的前身。
    * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。
    * 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
    * */
    public int longestStrChain(String[] words) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(String cur:words){
            int length=cur.length();
            int[] num=getNum(cur);
            List<int[]> list=map.getOrDefault(length,new ArrayList<>());
            list.add(num);
            map.put(length,list);
        }
        int result=1;
        for(int i=16;i>=1;i--){
            List<int[]> cur  = map.getOrDefault(i,new ArrayList<>());
            List<int[]> next = map.getOrDefault(i+1,new ArrayList<>());
            for(int[] curr:cur){
                for(int j=0;j<next.size();j++){
                    if(isChain(curr,next.get(j))){
                        curr[26]=Math.max(curr[26],next.get(j)[26]+1);
                        result=Math.max(result,curr[26]);
                    }
                }
            }
        }
        return result;
        //
    }

    private int[] getNum(String cur){
        //第27位用来存储以该字符串为首的最大字符串链的长度
        int[] result=new int[27];
        for(int i=0;i<cur.length();i++){
            result[cur.charAt(i)-'a']++;
        }
        result[26]=1;
        return result;
    }

    private boolean isChain(int[] cur1, int [] cur2){
        boolean flag=true;
        for(int i=0;i<26;i++){
            if(cur1[i]==cur2[i])
                continue;
            if(cur2[i]-cur1[i]==1&&flag){
                flag=false;
                continue;
            }
            return false;
        }
        return true;
    }
}
