package LINTCODE14;

public class LINTCODE1348 {
    /*Description
    * 给定Excel工作表中显示的列名称，返回其对应的列号。
    * */

    public int titleToNumber(String s) {
        int res=0;
        for(int i=0;i<s.length();i++) {
            int cur=s.charAt(i) - 'A' + 1;
            res=res*26+cur;
        }
        return res;
        // write your code here
    }
}
