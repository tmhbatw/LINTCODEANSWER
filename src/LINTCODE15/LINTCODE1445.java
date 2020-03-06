package LINTCODE15;

public class LINTCODE1445 {
    /*Description
    * 输入两个字符串 s 和 t，判断 s 能否在删除一些字符后得到 t。
    * */

    public boolean canGetString(String s, String t) {
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
