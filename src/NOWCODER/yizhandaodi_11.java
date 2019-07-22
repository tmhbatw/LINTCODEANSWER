package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_11 {
    /*Description
    *帮助牛牛计算 1+（1+2）+（1+2+3）+...+(1+2+3+...+n)
    * 输入描述:
    * 输入一个整数
    * 输出描述:
    * 输出一个整数
    * */

    public static void main(String[] args){
        int n=new Scanner(System.in).nextInt();
        int[] num=new int[n+1];
        int sum=0;
        for(int i=1;i<n+1;i++){
            num[i]=num[i-1]+i;
            sum+=num[i];
        }
        System.out.println(sum);

    }
}
