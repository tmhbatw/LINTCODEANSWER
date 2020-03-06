package LINTCODE15;

public class LINTCODE1459 {
    /*Description
    * 有一个01字符串str。其中只可能会出现三个单词，两个字节的单词10或者11，
    * 一个字节的单词0。判断字符串中最后一个单词的字节数。
    * */

    public int judgeTheLastNumber(String str) {
        int time=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1') {
                time = 2;
                i++;
            }else
                time=1;
        }
        return time;
        // Write your code here
    }
}
