package LINTCODE4;

public class LINTCODE353 {
    /*Description
    * 给定字符串S，找到最大的字母字符，其大写和小写字母均出现在S中，则返回此字母的大写，若不存在则返回"NO"。
    * */

    public String largestLetter(String s) {
        boolean[] exist=new boolean[128];
        for(int i=0;i<s.length();i++){
            exist[s.charAt(i)]=true;
        }
        for(int i='Z';i>='A';i--){
            if(exist[i]&&exist[i-'A'+'a'])
                return (char)(i)+"";
        }
        return "NO";
        // write your code here
    }
}
