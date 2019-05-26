package LINTCODE;

public class LINTCODE55 {
    /*Description
    * Compare two strings A and B, determine whether A contains all of the characters in B.\
    * The characters in string A and B are all Upper Case letters.
    * */

    /*Solution
    * 26位长度的数组即可保存A、B两数组的每一个字符的数量
    * 比较B字符串每一字符数是否小于a数量即可
    * */

    public boolean compareStrings(String A, String B) {
        char[] a=new char[26],b=new char[26];
        change(a,A);
        change(b,B);
        for(int i=0;i<26;i++){
            if(b[i]>a[i])
                return false;
        }
        return true;
        // write your code here
    }

    private void change (char[] result,String res){
        for(int i=0;i<res.length();i++)
            result[res.charAt(i)-'A']++;
    }
}
