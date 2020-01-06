package LINTCODE9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LINTCODE856 {
    /*Description
    * 给出两个句子words1和words2（每个用一个字符串数组表示），和一个相似词对数组pairs，你需要判断两个句子是否相似。
    * 例如，如果相似词对是pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]，那么words1 = great acting skills和words2 = fine drama talent是相似的。
    * 需要注意，相似关系是不可传递的。例如，如果"great"和"fine"相似，"fine"和"good"相似，"great"和"good"不是一定相似的。
    * 然而，相似性是对称的。例如，"great"和"fine"相似，则"fine"和"great"也是相似的，这两者是等价的。
    * 另外，一个单词永远与它本身相似。例如，句子words1 = ["great"], words2 = ["great"], pairs = []是相似的，尽管没有相似词对。
    * 最后，两个句子只有在单词数相等的情况下才可能相似。所以，句子words1 = ["great"]永远不可能与句子words2 = ["doubleplus","good"]相似。
    * */

    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length!=words2.length)
            return false;
        HashMap<String, HashSet<String>> map=new HashMap<>();
        for(List<String> cur:pairs){
            String first=cur.get(0);
            if(!map.containsKey(first))
                map.put(first,new HashSet<>());
            HashSet<String> set=map.get(first);
            set.add(cur.get(1));
        }
        for(int i=0;i<words1.length;i++){
            HashSet<String> cur1=map.get(words1[i]);
            HashSet<String> cur2=map.get(words2[i]);
            if((cur1==null||!cur1.contains(words2[i]))&&(cur2==null||!cur2.contains(words1[i])))
                return false;
        }
        return true;
        // write your code here
    }
}
