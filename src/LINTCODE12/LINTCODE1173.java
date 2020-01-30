package LINTCODE12;

public class LINTCODE1173 {
    /*Description
    *给定一个字符串句子，反转句子中每一个单词的所有字母，
    * 同时保持空格和最初的单词顺序。
    * */

    public String reverseWords(String s) {
        StringBuilder result=new StringBuilder();
        String[] res=s.split(" ");
        for(String cur:res){
            StringBuilder curS=new StringBuilder(cur);
            result.append(curS.reverse());
            result.append(" ");
        }
        return result.deleteCharAt(result.length()-1).toString();
        // Write your code here
    }
}
