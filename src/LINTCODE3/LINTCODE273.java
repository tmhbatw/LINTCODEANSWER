package LINTCODE3;

import java.util.Arrays;

public class LINTCODE273 {
    /*Description
    * 你有一场考试，考试时间为 120 分钟。考试有多道题目，你的作答顺序不受限制。对于第 i 道题目，你有三种不同的策略可以选择：
    * 直接跳过这道题目，不花费时间，本题得 0 分。
    * 只做这道题目一部分，花费 p[i] 分钟的时间，本题可以得到 part[i] 分。
    * 做完整道题目，花费 f[i] 分钟的时间，本题可以得到 full[i] 分。
    * 依次给定 4 个数组：p，part，f，full，请你计算出你最多能得到多少分。
    * */

    public int exam(int[] p, int[] part, int[] f, int[] full) {
        int number=p.length;
        int[] score=new int[121];
        for(int i=0;i<number;i++){
            int curP=p[i];
            int curPart=part[i];
            int curF=f[i];
            int curFull=full[i];
            for(int j=120;j>=0;j--){
                if(j>=curP){
                    score[j]=Math.max(score[j],score[j-curP]+curPart);
                }
                if(j>=curF){
                    score[j]=Math.max(score[j],score[j-curF]+curFull);
                }
            }
        }
        System.out.println(Arrays.toString(score));
        return score[120];
        // write your code here
    }
}
