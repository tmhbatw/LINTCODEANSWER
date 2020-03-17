package LINTCODE10;

public class LINTCODE926 {
    /*Description
    * 这是一道最短单词距离的拓展题目。唯一不同之处是现在单词1可以与单词2相同。
    * 给出一个单词列表和两个单词单词1,单词2，返回这两个单词在列表中的最短距离。
    * 单词1和单词2可能是相同的，它们代表列表中的两个独立的单词。
    * */

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)){
            int result=Integer.MAX_VALUE;
            int index=-1;
            for(int i=0;i<words.length;i++){
                if(words[i].equals(word1)){
                    if(index!=-1)
                        result=Math.min(result,i-index);
                    index=i;
                }
            }
            return result;
        }
        int index1=-1;
        int index2=-1;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            String cur=words[i];
            if(cur.equals(word1)){
                index1=i;
                if(index2!=-1)
                    result=Math.min(index1-index2,result);
            }else if(cur.equals(word2)){
                index2=i;
                if(index1!=-1)
                    result=Math.min(index2-index1,result);
            }
        }
        return result;
        // Write your code here
    }
}
