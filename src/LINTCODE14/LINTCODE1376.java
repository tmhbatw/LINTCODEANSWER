package LINTCODE14;

public class LINTCODE1376 {
    /*Description
    * 给两等长字符串，当他们等价时，返回true。
    * 两等长字符串a和b等价当且仅当符合以下二者条件之一：
    * 完全一样。
    * 如果把字符串a拆成两半（均分），长度分别为a1和a2，字符串b也拆成两半，长度分别为b1和b2，然后满足以下之一：
    * a1和b1等价，a2和b2等价。
    * a1和b2等价，a2和b1等价。
    * */

    public boolean isEquivalentStrings(String s1, String s2) {
        int length=s1.length();
        if(length==0||s1.equals(s2))
            return true;
        if(length%2==1)
            return false;
        String s11=s1.substring(0,length/2);
        String s12=s1.substring(length/2,length);
        String s21=s2.substring(0,length/2);
        String s22=s2.substring(length/2,length);
        return isEquivalentStrings(s11,s21)&&isEquivalentStrings(s12,s22)||
                isEquivalentStrings(s11,s22)&&isEquivalentStrings(s12,s21);
            // Write your code here
    }
}
