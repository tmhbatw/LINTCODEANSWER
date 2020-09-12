package LEETCODE.AutumnCompetition;

import java.util.Arrays;

public class question2 {
    /*Description
    * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。
    * 小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
    * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
    * */

/*    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int result=0;
        int mod=1000000007;
        for(int cur:staple){
            for(int curr:drinks){
                if(cur+curr<=x){
                    result++;
                    if(result==mod)
                        result=0;
                }
            }
        }
        return result;
    }*/

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        if(staple.length==0||drinks.length==0)
            return 0;
        Arrays.sort(drinks);
        long result=0;
        int mod=1000000007;
        int length=drinks.length;
        for(int cur:staple){
            if(cur>=x)
                continue;
            int last=x-cur;
            if(drinks[0]>last)
                continue;
            int left=0,right=length-1;
            int mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                if(drinks[mid]<=last&&(mid==length-1||drinks[mid+1]>last))
                    break;
                else if(drinks[mid]<=last)
                    left=mid+1;
                else
                    right=mid-1;
            }
            result+=mid+1;

        }
        result%=mod;
        return (int)result;
    }

    public static void main(String[] args){
        int a=100;
        int b=101;
        System.out.println(a%b);
    }
}
