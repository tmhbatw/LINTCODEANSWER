package LINTCODE14;

public class LINTCODE1327 {
    /*Description
    * 给定一个字符串，要求去掉一个字符，使得剩下的两个字符串按顺序拼接在一起，使得最后得到的字符串字典序最小。
    * 返回这个字符串。
    * */

    public String deleteString(String str) {
        int index=0;
        for(;index<str.length();index++){
            if (index == str.length() - 1 || str.charAt(index)>str.charAt(index+1))
                break;
        }
        return str.substring(0,index)+str.substring(index+1);
        // Write your code here.
    }
}
