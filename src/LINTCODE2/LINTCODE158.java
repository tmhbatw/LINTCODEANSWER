package LINTCODE2;

public class LINTCODE158 {
    /*Description
    * 写出一个函数 anagram(s, t) 判断两个字符串是否可以通过改变字母的顺序变成一样的字符串。
    */

    /*Solution
    * 创建两个数组用来保存两个字符串每一个字符的数量，比较两个数组每一项是否相等即可
    * */

    public boolean anagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] ss=new int[128];
        int[] tt=new int[128];
        for(int i=0;i<s.length();i++)
            ss[s.charAt(i)]++;
        int count=0;
        for(int i=0;i<t.length();i++){
            if(tt[t.charAt(i)]<ss[t.charAt(i)]){
                tt[t.charAt(i)]++;
                count++;
            }
        }
        return count==s.length();
        // write your code here
    }
}
