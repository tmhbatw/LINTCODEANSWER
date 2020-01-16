package LINTCODE13;

public class LINTCODE1243 {
    /*Description
    * 计算字符串中的单词数，其中一个单词定义为不含空格的连续字符串。
    * */

    public int countSegments(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '&&(i==0||s.charAt(i-1)==' '))
                result++;
        }
        return result;
        // write yout code here
    }
}
