package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_6 {
    /*Description
    * 小w想和你van纸牌    小w有两张纸牌，两张纸牌上都有相同的正整数n    每一轮一张纸牌上的数都可以减去小于等于另外一张纸牌上的数的数
    * 每一轮只能操作和上轮不同的纸牌    小w想知道三轮之后两纸牌上数字之和的最小值    注意，不能减为负数
    * 输入描述:
    * 第一行1个正整数n。
    * 输出描述:
    * 一行一个整数表示三轮之后两纸牌上数字和的最小值
    * */

    public static void main(String[] args){
        int n=new Scanner(System.in).nextInt();
        if((n&1)==1){
            System.out.println(n/2+1);
        }
        else{
            System.out.println(n/2);
        }
    }
}
