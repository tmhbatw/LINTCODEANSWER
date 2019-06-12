package LINTCODE5;

public class LINTCODE414 {
    /*Description
    * 将两个整数相除，要求不使用乘法、除法和 mod 运算符。
    * 如果溢出(超出32位有符号整型表示范围)，返回 2147483647 。
    * */

    /*Solution
    * 基本思路为相减
    * 我们可以将除数左移从而减少相减的次数
    * 我们可以转化为long型避免溢出
    * */


    public int divide(int dividend, int divisor) {
        Long div=Long.valueOf(dividend);
        if(divisor==0)
            return Integer.MAX_VALUE;
        boolean minus=false;
        if(div<0&&divisor<0){
            div=-div;
            divisor=-divisor;
        }else if(div<0){
            div=-div;
            minus=true;
        }else if(divisor<0){
            divisor=-divisor;
            minus=true;
        }
        int move=0;
        while((divisor<<move)<=Integer.MAX_VALUE/2&&div>(divisor<<move)){
            move++;
        }
        System.out.println(move-1);
        Long result=0l;
        for(int i=move;i>=0;i--){
            while(div>=(divisor<<i)){
                div-=(divisor<<i);
                result+=(1<<i);
            }
        }
        if(minus)
           result= -result;
        if(result>= Integer.MAX_VALUE||result<Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return Math.toIntExact(result);
        // write ur code here

    }

}
