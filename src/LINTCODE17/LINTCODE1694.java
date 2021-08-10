package LINTCODE17;

import java.util.Arrays;

public class LINTCODE1694 {
    /*Description
    * 你是一个猎人,现在你面对一队排成一排的怪物。每只怪物都有一定的主动攻击力atk1[]和附带攻击力atk2[]。
    * 每回合你可以击杀任意一头怪物,此时你受到的伤害为（这只怪物的主动攻击力+相邻的两只怪物的附带攻击力）。
    * 请问你如何bbbbbg选择杀怪物的顺序，使自己杀完所有的怪物后受到的伤害最小?输出受到的最小伤害。
    * */

    public int killMonster(int[] atk1, int[] atk2) {
        int sum= Arrays.stream(atk1).sum();
        int length=atk2.length;
        if(length<=1)
            return sum;
        int[] num=new int[length+2];
        for(int i=0;i<length;i++){
            num[i+1]=atk2[i];
        }
        int[][] dp=new int[length+2][length+2];
        for(int i=0;i<length;i++){
            int val = num[i] + num[i + 2];
            dp[i+1][i+1]= val;
//            if(i>0){
//                dp[i][i+1]=num[i-1]+num[i+2]+Math.min(num[i-1]+num[i+1], val);
//            }
        }
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                dp[i+1][j+1]=dp[i+1][j]+num[i]+num[j+2];
                for(int k=i;k<j;k++){
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1],dp[i+1][k]+dp[k+2][j+1]+num[i]+num[j+2]);
                }
            }
        }
        return sum+dp[1][dp.length-2];
        // Write your code here
    }

    public static void main(String[] args){
        int[] num1=new int[]{1,4,5,4};
        int[] num2=new int[]{3,4,9,1};
        System.out.println(new LINTCODE1694().killMonster(num1,num2));
    }
}
