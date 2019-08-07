package LINTCODE9;

import java.util.HashMap;
import java.util.List;

public class LINTCODE855 {
    /*Description
    *给出两个句子“words1”、“words2”(每个单词都表示为字符串数组) 和一组相似的单词对“pair”，判断两个句子是否相似。
    * 例如，' words1 = ["great"， "acting"，" skills"]和' words2 = ["fine"， "drama"， "talent"]是相似的，如果相似的单词对是' pair = [[great"， "good"]， ["fine"， "good"]， ["acting"，"drama"]， ["skills"，"talent"]]。
    * 注意，相似性关系是可传递的。例如，如果“great”和“good”相似，“fine”和“good”相似，那么“great”和“fine”相似。
    * 相似性也是对称的。例如，“great”和“fine”相似等同于“fine”和“great”相似。
    * 而且，一个单词总是和它自己相似。例如，' words1 = ["great"] '、' words2 = ["great"] '、' pair =[] '这几个句子是相似的，即使没有指定相似的单词对。
    * 最后，句子只有在单词数量相同的情况下才能相似。所以像words1 = ["great"]这样的句子永远不可能和words2 = ["doubleplus"，"good"]相似。
    * */

    int[] dp=new int[4000];
    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        if(words1.size()!=words2.size())
            return false;
        int index=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(List<String> list:pairs){
            String cur1=list.get(0);
            String cur2=list.get(1);
            if(!map.containsKey(cur1)) {
                map.put(cur1, index++);
                dp[index]=index++;
            }
            if(!map.containsKey(cur2)) {
                map.put(cur2, index++);
                dp[index]=index++;
            }
            int index1=map.get(cur1);
            int index2=map.get(cur2);
            int union1=getUnion(index1);
            int union2=getUnion(index2);
            if(union1==union2)
                continue;
            dp[union1]=union2;
        }
        for(int i=0;i<words1.size();i++){
            if(words1.get(i).equals(words2.get(i)))
                continue;
            if(!map.containsKey(words1.get(i))||!map.containsKey(words2.get(i))||getUnion(map.get(words1.get(i)))!=getUnion(map.get(words2.get(i))))
                return false;
        }
        return true;
        //
    }

    private int getUnion(int index){
        if(dp[index]!=index)
            return getUnion(dp[index]);
        return index;
    }
}
