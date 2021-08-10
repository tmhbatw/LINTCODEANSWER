package LINTCODE12;

public class LINTCODE1100 {
    /*Description
    * 有一个奇怪的打印机，它有如下两个特别的要求：
    * 1.这个打印机只每次能打印一个由相同字母构成的串。
    * 2. 在每一轮当中，这个打印机可以打印从任意位置开始到任意位置结束的新字母，并且可以覆盖掉原来存在的字母。
    * 给定一个仅包含小写英文字母的字符串，你的任务是计算打印机为了打印出它锁需要的最小轮数。
    * */

    public int strangePrinter(String s){
        int length=s.length();
        int[][] dp=new int[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=1;
        }
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                dp[i][j]=dp[i][j-1]+1;
                for(int k=j-1;k>=i;k--){
                    if(s.charAt(k)==s.charAt(j)){
                        dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j-1]);
                    }
                }
            }
        }
        return dp[0][length-1];
        // write your code here
    }
}
