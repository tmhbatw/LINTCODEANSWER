package LINTCODE5;

public class LINTCODE422 {

    /*Description
    * 给定一个字符串， 包含大小写字母、空格 ' '，请返回其最后一个单词的长度。
    * 如果不存在最后一个单词，请返回 0 。
    * */

    /*Solution
    * 分割空格输出即可
    * */
    public int lengthOfLastWord(String s) {
        if(s.length()==0)
            return 0;
        String[] ss=s.split(" ");
        return ss[ss.length-1].length();
        // write your code here
    }
}
