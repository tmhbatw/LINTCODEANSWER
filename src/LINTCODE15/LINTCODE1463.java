package LINTCODE15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1463 {
    /*Description
    *我们定义，两个论文的相似度为最长的相似单词子序列长度 * 2 除以两篇论文的总长度。
    * 给定两篇论文words1，words2（每个表示为字符串数组），和相似单词对列表pairs，求两篇论文的相似度。
    * 注意：相似关系是可传递的。例如，如果“great”和“good”类似，而“fine”和“good”类似，那么“great”和“fine”类似。
    * 相似性也是对称的。 例如，“great”和“good”相似，则“good”和“great”相似。
    * 另外，一个词总是与其本身相似。
    * */

    public float getSimilarity(List<String> words1, List<String> words2, List<List<String>> pairs) {
        if(words1.isEmpty()||words2.isEmpty())
            return 1;
        Map<String,String> map=new HashMap<>();
        for(List<String> list:pairs){
            map.putIfAbsent(list.get(0),list.get(0));
            map.putIfAbsent(list.get(1),list.get(1));
            String type1=getType(map,list.get(0));
            String type2=getType(map,list.get(1));
            if(!type1.equals(type2)){
                map.put(type2,type1);
            }
        }
        List<String> w1=new ArrayList<>();
        List<String> w2=new ArrayList<>();
        for(String cur:words1)
            w1.add(getType(map,cur));
        for(String cur:words2)
            w2.add(getType(map,cur));
        int[][] dp=new int[w1.size()+1][w2.size()+1];
        int result=0;
        for(int i=0;i<w1.size();i++){
            for(int j=0;j<w2.size();j++){
                if(w1.get(i).equals(w2.get(j))) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    result=Math.max(result,dp[i+1][j+1]);
                }else{
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        float f= 2.0F;
        return result*f/(w1.size()+w2.size());
        // Write your code here
    }

    private String getType(Map<String,String> map,String val){
        if(!map.containsKey(val))
            return val;
        if(map.get(val).equals(val))
            return val;
        return getType(map,map.get(val));
    }
}
