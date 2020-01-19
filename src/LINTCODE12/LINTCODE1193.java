package LINTCODE12;

public class LINTCODE1193 {
    /*Description
     * 给定一个单词，你需要判断其中大写字母的使用是否正确。
     * 当下列情况之一成立时，我们将单词中大写字母的用法定义为正确：
     * 这个单词中的所有字母都是大写字母，如“USA”。
     * 这个单词中的所有字母都不是大写字母，如“lintcode”。
     * 如果它有多个字母，例如“Google”，那么这个单词中的第一个字母就是大写字母。
     * 否则，我们定义该单词没有以正确的方式使用大写字母。
     * */

    public boolean detectCapitalUse(String word) {
        if(word.length()<=1)
            return true;
        if(word.charAt(0)<='Z'&&word.charAt(0)>='A'&&word.charAt(1)<='Z'&&word.charAt(1)>='A'){
            for(int i=2;i<word.length();i++){
                if(word.charAt(i)<='z'&&word.charAt(i)>='a')
                    return false;
            }
            return true;
        }
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)<='Z'&&word.charAt(i)>='A')
                return false;
        }
        return true;
        // write your code here
    }
}
