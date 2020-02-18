package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1185 {
    /*Description
    * 给出两个代表两个复数的字符串。
    * 您需要返回表示其乘积的字符串。 注意根据定义i^2 = -1。
    * */
    /*Solution
    * 注意0的情况
    * */

    public String complexNumberMultiply(String a, String b) {
        String[] aa=a.split("\\+");
        String[] bb=b.split("\\+");
        int a0=aa[0].length()==0?0:Integer.parseInt(aa[0]);
        int a1=aa[1].length()==0?0:Integer.parseInt(aa[1].substring(0,aa[1].length()-1));
        int b0=bb[0].length()==0?0:Integer.parseInt(bb[0]);
        int b1=bb[1].length()==0?0:Integer.parseInt(bb[1].substring(0,bb[1].length()-1));
        int first=a0*b0-a1*b1;
        int second=a1*b0+a0*b1;

        return first+"+"+second+"i";
        // Write your code here
    }

    public static void main(String[] args){
        String s="+1";
        System.out.println(s.split("\\+")[0].length());
    }
}
