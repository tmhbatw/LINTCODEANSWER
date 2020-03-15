package LINTCODE14;

public class LINTCODE1342 {
    /*Description
    * 给定一个只包含小写字母和"?"的字符串，现在你可以将"?"替代成任意的一个小写字母，使得最后得到的字符串相邻位置的字符各不相同。你可以返回任意一个合法的字符串。
    * */

    /*Solution
    * 测试用例不太完善
    * */
    public String substituteString(String str) {
        StringBuilder sb=new StringBuilder();
        int length=str.length();
        for(int i=0;i<length;i++){
            char cur=str.charAt(i);
            if(cur!='?')
                sb.append(cur);
            else{
                char c=i>=1?(char)(sb.charAt(i-1)+1):'a';
                if(i<length-1&&c==str.charAt(i+1))
                    c=(char)(c+1);
                sb.append(c);
            }
        }
        return sb.toString();
        // Write your code here.
    }
}
