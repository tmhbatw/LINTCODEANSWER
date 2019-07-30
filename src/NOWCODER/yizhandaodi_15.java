package NOWCODER;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class yizhandaodi_15 {
    /*Description
    * 链接：今年是国际数学联盟确定的“2000——世界数学年”，又恰逢我国著名数学家华罗庚先生诞辰90周年。
    * 在华罗庚先生的家乡江苏金坛，组织了一场别开生面的数学智力竞赛的活动，你的一个好朋友XZ也有幸得以参加。
    * 活动中，主持人给所有参加活动的选手出了这样一道题目： 设有一个长度为N的数字串，要求选手使用K个乘号将它分成K+1个部分，
    * 找出一种分法，使得这K+1个部分的乘积能够为最大。 同时，为了帮助选手能够正确理解题意，主持人还举了如下的一个例子：
    *  有一个数字串：312， 当N=3，K=1时会有以下两种分法： 1) 3*12=36 2) 31*2=62 这时，符合题目要求的结果是：31*2=62 现在，请你帮助你的好朋友XZ设计一个程序，求得正确的答案。
    * 输入描述:
    * 第一行共有2个自然数N，K（6 ≤ N ≤ 40，1 ≤ K ≤ 6）第二行是一个长度为N的数字串。
    * 输出描述:
    * 输出所求得的最大乘积（一个自然数）。
    * */

    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int K=s.nextInt();
        String n=s.next();
        BigDecimal[][] num=new BigDecimal[N][K+1];
        for(int i=0;i<num.length;i++){
            num[i][0]=new BigDecimal(n.substring(0,i+1));
        }
        for(int j=1;j<K+1;j++){
            for(int i=j;i<N;i++){
                BigDecimal max= BigDecimal.valueOf(0);
                for(int k=j-1;k<i;k++){
                    BigDecimal cut= BigDecimal.valueOf(Long.parseLong(n.substring(k+1,i+1)));
                    max=max.max(num[k][j-1].multiply(cut));
                }
                num[i][j]=max;
            }
        }

        System.out.println(num[N-1][K]);
    }

}