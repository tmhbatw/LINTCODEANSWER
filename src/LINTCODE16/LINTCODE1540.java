package LINTCODE16;

public class LINTCODE1540 {
    /*Description
    * 给两个字符串 S 和 T, 判断 S 能不能通过删除一些字母(包括0个)变成 T.
    * */

    public boolean canConvert(String s, String t) {
        if(s==null)
            return false;
        int length=t.length();
        if(length==0)
            return true;
        int index=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(index))
                index++;
            if(index==length)
                return true;
        }
        return false;
        // Write your code here
    }
}
