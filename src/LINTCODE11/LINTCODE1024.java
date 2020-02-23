package LINTCODE11;

public class LINTCODE1024 {
    /*Description
    * 给定一个字符串S 和一个单词字典 words，问, words中一共有多少个单词words[i]是字符串S的子序列?
    * 注意, 子序列不同于子串, 子序列不要求连续.
    * */

    public int numMatchingSubseq(String S, String[] words) {
        int result=0;
        for(String cur:words)
            if(match(S,cur))
                result++;
        return result;
           // Write your code here
    }

    private boolean match(String S,String cur){
        int index=0;
        for(int i=0;i<S.length();i++){
            if(index==cur.length())
                return true;
            if(S.charAt(i)==cur.charAt(index))
                index++;
        }
        return index==cur.length();
    }
}
