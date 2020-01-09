package LINTCODE10;

public class LINTCODE924 {
    /*Description
    *给出一个单词列表和两个单词单词1,单词2，返回列表中这两个单词之间的最短距离。
    * */


    public int shortestDistance(String[] words, String word1, String word2) {
        int index1=-1;
        int index2=-1;
        int result=Integer.MAX_VALUE;
        for(int i=0;i< words.length;i++){
            if(words[i].equals(word1)){
                index1=i;
                if(index2!=-1)
                    result=Math.min(result,Math.abs(index1-index2));
            }else if (words[i].equals(word2)){
                index2=i;
                if(index1!=-1)
                    result=Math.min(result,Math.abs(index1-index2));
            }
        }
        return result;
        // Write your code here
    }
}
