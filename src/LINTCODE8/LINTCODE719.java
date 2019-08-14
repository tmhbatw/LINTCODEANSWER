package LINTCODE8;

public class LINTCODE719 {

    /*Description
    * 给一个字符串类型的数字, 写一个方法去找到最大值, 你可以在任意两个数字间加 + 或 *
    * */

    public int calcMaxValue(String str) {
        int res=0;
        for(int i=0;i<str.length();i++){
            int cur=str.charAt(i)-'0';
            res=Math.max(res+cur,res*cur);
        }
        return res;
        // write your code here
    }
}
