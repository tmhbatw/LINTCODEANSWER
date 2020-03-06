package LINTCODE15;

public class LINTCODE1472 {
    /*Description
    * 给定两个字符串 s和t，每次可以任意交换s的奇数位或偶数位上的字符，即奇数位上的字符能与其他奇数位的字符互换，
    * 而偶数位上的字符能与其他偶数位的字符互换，问能否经过若干次交换，使s变成t。
    * */

    public String isTwin(String s, String t) {
        if(s.length()!=t.length())
            return "No";
        int[] num1=new int[128];
        int[] num2=new int[128];
        for(int i=0;i<s.length();i+=2){
            num1[s.charAt(i)]++;
            num2[t.charAt(i)]++;
        }
        if(!isSame(num1,num2))
            return "No";
        for(int i=1;i<s.length();i+=2){
            num1[s.charAt(i)]++;
            num2[s.charAt(i)]++;
        }
        if(isSame(num1,num2))
            return "Yes";
        return "No";
        // Write your code here
    }

    private boolean isSame(int[] s,int[] t){
        for(int i=0;i<s.length;i++){
            if(s[i]!=t[i])
                return false;
        }
        return true;
    }
}
