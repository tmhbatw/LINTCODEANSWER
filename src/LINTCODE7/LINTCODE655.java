package LINTCODE7;

public class LINTCODE655 {
    /*Description
    *以字符串的形式给出两个非负整数 num1 和 num2，返回 num1 和 num2 的和。
    * */

    public String addStrings(String num1, String num2) {
        if(num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        String res="";
        int num1Length=num1.length();
        int num2Length=num2.length();
        int count=0;
        int curIndex=0;
        while(curIndex<num2Length){
            int number1=num1.charAt(num1Length-curIndex-1)-'0';
            int number2=num2.charAt(num2Length-curIndex-1)-'0';
            int cur=(number1+number2+count)%10;
            count=(number1+number2+count)/10;
            res=cur+res;
            curIndex++;
        }
        while(curIndex<num1Length){
            int number1=num1.charAt(num1Length-curIndex-1)-'0';
            int cur=(number1+count)%10;
            count=(number1+count)/10;
            res=cur+res;
            curIndex++;
        }
        return count==0?res:1+res;
        // write your code here
    }
}
