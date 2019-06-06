package LINTCODE3;

public class LINTCODE211 {
    /*Description
    *给定两个字符串，请设计一个方法来判定其中一个字符串是否为另一个字符串的置换。
    * */

    /*Solution
    * 创建一个数组存储每一个char出现的次数
    * */

    public boolean Permutation(String A, String B) {
        char[] a=new char[128];
        char[] b=new char[128];
        for(int i=0;i<A.length();i++)
            a[A.charAt(i)]++;
        for(int i=0;i<B.length();i++){
            if (b[B.charAt(i)] < a[B.charAt(i)]){
                    b[B.charAt(i)]++;
            }else
                return false;
        }
        return A.length()==B.length();
        // write your code here
    }
}
