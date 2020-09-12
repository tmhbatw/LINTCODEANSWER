package LINTCODE4;

public class LINTCODE321 {
    /*Description
    * 定义若一个字符串的每个字符均为'1'，则该字符串称为完美字符串。给定一个只由'0'和'1'组成的字符串s和一个整数k。你可以对字符串进行任意次以下操作
    * 选择字符串的一个区间长度不超过k的区间[l, r]，将区间内的所有'0'修改成'1'，将区间内所有的'1'修改成'0'。
    * 你最少需要多少次操作，可以将字符串s修改成一个完美字符串
    * */

    public int perfectString(String s, int k) {
        int result=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='0'){
                int time=1;
                while(i<length-1&&s.charAt(i+1)=='0'){
                    time++;i++;
                }
                result+=Math.ceil(1.0*time/k);
            }
        }
        return result;
        // Write your code here
    }
}
