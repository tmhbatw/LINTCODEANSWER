package LINTCODE19;

public class LINTCODE1820 {
    /*Description
    * 给定一个字符串str，返回字符串中字母顺序最大的而且同时在字符串中出现大写和小写的字母。
    * 如果不存在这样的字母，返回‘~‘。
    * */

    public char findLetter(String str) {
        boolean[] small=new boolean[26];
        boolean[] big=new boolean[26];
        for(int i=0;i<str.length();i++){
            char cur=str.charAt(i);
            if(cur<='Z'&&cur>='A')
                big[cur-'A']=true;
            else
                small[cur-'a']=true;
        }
        for(int i=25;i>=0;i--){
            if(small[i]&&big[i])
                return (char)('A'+i);
        }
        return '~';
        // Write your code here.
    }
}
