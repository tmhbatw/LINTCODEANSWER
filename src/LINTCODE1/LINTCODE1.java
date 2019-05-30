package LINTCODE1;

public class LINTCODE1 {
    /*
    Description
        Write a function that add two numbers A and B.
    * */


    /*当然可以使用加法运算符返回题目答案
      亦可以使用按位运算符号
      a^b得出结果即为a与b两整数无进位结果
      a&b<<1得出结果为a与b两整数进位结果
      二者相加知道没有进位即为运算结果
    * */


    public static  int aplusb(int a, int b) {
        while((a&b)<<1!=0){
            int temp=a^b;
            b=(a&b)<<1;
            a=temp;
        }
        return a^b;
    }
}
