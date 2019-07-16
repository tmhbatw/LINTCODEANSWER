package LINTCODE6;

public class LINTCODE569 {
    /*Description
    * 任何数各位反复相加，最终得到一个个位数：若该数是9的倍数，则结果必为9，
    * 否则结果为该数的各个数位相加后对9取余。
    * */

    /*Solution
    * 任何数各位反复相加结果为该数的各个数位相加后对9取余(qu。
    * */

    public int addDigits(int num) {
        if(num==0)
            return 0;
        int result=0;
        while(num>0){
           result+=num%10;
           num/=10;
        }
        return result%9==0?9:result%9;
        // write your code here
    }
}
