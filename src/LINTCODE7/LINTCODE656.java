package LINTCODE7;

import java.util.Arrays;

public class LINTCODE656 {
    /*Description
    * 以字符串的形式给定两个非负整数 num1 和 num2，返回 num1 和 num2 的乘积。
    * */

    public String multiply(String num1, String num2) {
        if(num1.length()<num2.length()){
            String temp=num2;
            num2=num1;
            num1=temp;
        }
        int num1length=num1.length();
        int[] nums1=new int[num1length];
        for(int i=0;i<num1length;i++)
            nums1[num1length-i-1]=num1.charAt(i)-'0';
        int num2length=num2.length();
        int[] nums2=new int[num2length];
        for(int i=0;i<num2length;i++)
            nums2[num2length-i-1]=num2.charAt(i)-'0';
        int[][] res=new int[num2length][num1length+num2length];
        for(int i=0;i<num2length;i++){
            int add=0;
            int divation=i;
            for(int j=0;j<num1length;j++){
                int cur=nums2[i]*nums1[j]+add;
                res[i][j+divation]=cur%10;
                add=cur/10;
            }
            res[i][num1length+divation]=add;
        }
        int add=0;
        String result="";
        for(int i=0;i<res[0].length;i++){
            int cur=0;
            for(int j=0;j<num2length;j++){
                cur+=res[j][i];
            }
            cur+=add;
            add=cur/10;
            cur%=10;
            result=cur+result;
        }
        while(result.charAt(0)=='0'&&result.length()>=2){
            result=result.substring(1);
        }
        return result;
        // write your code here
    }
}
