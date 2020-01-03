package LINTCODE7;

public class LINTCODE693 {
    /*Description
    *给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
    * */

    /*Solution
    * 找到这个字符串中最小的一个数字然后移除前面的所有数字，更新k的值，将问题转化为 一个子问题；
    *重复该过程即可
    * */


    public String removeKdigits(String num, int k) {
        if(num.length()==k)
            return "0";
        String result=recursion(num,k);
        while(result.charAt(0)=='0') {
            if(result.length()==1)
                return result;
            result = result.substring(1);
        }
        return result;
        // write your code here.
    }

    private String recursion(String num,int k){
        if(k==0)
            return num;
        if(num.length()==k)
            return "";
        int min=num.charAt(0)-'0';
        int index=0;
        for(int i=1;i<num.length();i++){
            int cur=num.charAt(i)-'0';
            if(cur<min){
                min=cur;
                index=i;
            }
        }
        if(index<=k)
            return num.charAt(index)+recursion(num.substring(index+1),k-index);
        return recursion(num.substring(0,index),k)+num.substring(index);
    }

    public static void main(String[] args){
        String cur="123";
        System.out.println(cur.substring(3));
    }

}
