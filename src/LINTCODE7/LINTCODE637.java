package LINTCODE7;

public class LINTCODE637 {
    /*Description
    * 给定一个非空字符串 word 和缩写 abbr，返回字符串是否可以和给定的缩写匹配。
    * 比如一个 “word” 的字符串仅包含以下有效缩写：
    * */

    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0;
        for(int j=0;j<abbr.length();j++){
            char cur=abbr.charAt(j);
            if(cur<='9'&&cur>='0'){
                int res=cur-'0';
                if(res==0)
                    return false;
                while(j<abbr.length()-1&&abbr.charAt(j+1)>='0'&&abbr.charAt(j+1)<='9'){
                    res=res*10+(abbr.charAt(++j)-'0');
                }
                i+=res;
                continue;
            }
            if(i>=word.length()||word.charAt(i++)!=abbr.charAt(j))
                return false;
        }
        return i==word.length();
        // write your code here
    }
}
