package LINTCODE5;

public class LINTCODE408 {

    /*Description
    *Given two binary strings, return their sum (also a binary string).
    * */

    /*Solution
    * 二进制加法运算，按位运算输出结果即可
    * */

    public String addBinary(String a, String b) {
        String result="";
        int i=a.length()-1,j=b.length()-1;
        int count=0;
        while(i>=0||j>=0){
            int aa=i==-1?0:a.charAt(i--)-'0';
            int bb=j==-1?0:b.charAt(j--)-'0';
            int cur=(aa+bb+count)%2;
            count=(aa+bb+count)/2;
            result=cur+result;
        }
        if(count==1)
            return 1+result;
        return result;
        // write your code here
    }
}
