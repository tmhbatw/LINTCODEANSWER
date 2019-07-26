package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_18 {
    /*Description
    * 题目描述
    * 我们定义“好数”：对于一个正整数，若它只有0~9中的一种数字构成，我们就称其为好数。现在给你一个正整数，请判断它是否为好数。
    * 输入描述:
    * 单组输入。一个正整数x(1<=  x <= 10100000)
    * 输出描述:
    * 若该数x是“好数”则输出“YES”。否则输出“NO”。（没有双引号）
    * */

    public static void main(String[] arg){
        double a=4.0;
        double b=3.6;
        System.out.println(a-b);
        Scanner s=new Scanner(System.in);
        String cur=s.next();
        char curr=cur.charAt(0);
        for(int i=1;i<cur.length();i++){
            if(curr!=cur.charAt(i)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
