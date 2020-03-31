package LINTCODE17;

import jdk.nashorn.internal.ir.BinaryNode;

public class LINTCODE1642 {
    /*Description
    * 给一个二进制字符串str和一个整数n，判断字符串的子串中是否包含了所有小于等于给定整数的非负整数的二进制表示。
    * */

    public String queryString(String str, int n) {
        boolean[] result=new boolean[n+1];
        int length=str.length();
        for(int i=0;i<length;i++){
            if(str.charAt(i)=='0')
                result[0]=true;
            else{
                int val=0;
                for(int j=i;j<length;j++){
                    val=val<<1|str.charAt(j)-'0';
                    if(val>n)
                        break;
                    result[val]=true;
                }
            }
        }
        return getResult(result);
        // Write your code here.
    }

    private String getResult(boolean[] result){
        for(boolean cur:result) {
            if (!cur)
                return "no";
        }
        return "yes";
    }
}
