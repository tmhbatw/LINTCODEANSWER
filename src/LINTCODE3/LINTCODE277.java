package LINTCODE3;

import java.util.List;

public class LINTCODE277 {
    /*Description
    * 给出一系列单词 words，以及两个不同的单词 wordA 和 wordB，请找出最近的两个 wordA 和 wordB 的间距。
    * 如果 words 中不存在 wordA 或 wordB，那么返回 -1−1。
    * */

    public int wordSpacing(List<String> words, String wordA, String wordB) {
        int indexA=-1;
        int indexB=-1;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<words.size();i++){
            String cur=words.get(i);
            if(cur.equals(wordA)){
                if(indexB!=-1){
                    result=Math.min(result,i-indexB);
                }
                indexA=i;
            }
            if(cur.equals(wordB)){
                if(indexA!=-1){
                    result=Math.min(result,i-indexA);
                }
                indexB=i;
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
        // write your code here.
    }
}
