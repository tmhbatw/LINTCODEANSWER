package LINTCODE19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1812 {
    /*Description
     * 给你一个正整数n,旋转数是将该数每一位数字旋转180°之后属于数并且不等于本身的数，同时保证旋转完的数也在1到n的范围之内。
     * 你应该在1 - n的范围内找出所有满足旋转数的定义的数并且返回一个数组res。例如 8069->8096，769不能进行旋转，因为7进行180°旋转之后不再是数字
     * */

    public List<Integer> RotationNumber(int n) {
        if(n<=5)
            return Collections.emptyList();
        List<Integer> result=new ArrayList<>();
        if(n<=8)
            return result;
        result.add(6);
        result.add(9);
        if(n<=9)
            return result;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[6]=2;
        dp[8]=1;
        dp[9]=2;
        for(int i=10;i<=n;i++){
            int pre=i/10;
            int last=i%10;
            if(dp[pre]==2&&dp[last]>=1||dp[pre]>=1&&dp[last]==2) {
                dp[i] = 2;
                if(getRotation(i)<=n) {
                    result.add(i);
                }
            }
            else if(dp[pre]==1&&dp[last]==1)
                dp[i]=1;
        }
        return result;
        // write your code here
    }

    private int getRotation(int cur){
        String curr=String.valueOf(cur);
        int result=0;
        for(int i=0;i<curr.length();i++){
            int c=curr.charAt(i)-'0';
            if(c==6)
                c=9;
            else if(c==9)
                c=6;
            result=result*10+c;
        }
        return result;
    }
}
