package LINTCODE4;

public class LINTCODE310 {
    /*Description
    * 现在题目给出一个整数A。
    * 整数B是A的变形，由整数A的位数交替形成。
    * 依次为A的右数第一位数，左数第一位数，右数第二位数.....以此类推，得到整数B。
    * */

    public String Distortion(String A) {
        int length=A.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length/2;i++){
            sb.append(A.charAt(length-i-1)).append(A.charAt(i));
        }
        if(length%2==1)
            sb.append(A.charAt(length/2));
        return sb.toString();
        //
    }
}
