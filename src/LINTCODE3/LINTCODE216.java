package LINTCODE3;

public class LINTCODE216 {
    /*Description
    * 假定有一种 isSubstring 的方法，可以检验某个单词是否为另一个单词的子字符串。给定 s1 和 s2，
    * 请设计一种方法来检验 s2 是否为 s1 的循环移动后的字符串。注意，只能调用一次 isSubstring 。
    * */


    public boolean isRotation(String s1, String s2) {
        if(s1.length()==0||s1.length()!=s2.length())
            return false;
        s1+=s1;
        return isSubstring(s1,s2);
        // write your code here
    }

    private boolean isSubstring(String s1,String s2){
        return s1.contains(s2);
    }
}
