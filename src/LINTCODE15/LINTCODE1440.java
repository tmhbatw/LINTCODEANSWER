package LINTCODE15;

import java.util.Arrays;

public class LINTCODE1440 {
    /*Description
    * 如果一个字符在字符串 S 中有且仅有出现一次，那么我们称其为独特字符。
    * 例如，在字符串 S = "LETTER" 中，"L" 和 "R" 可以被称为独特字符。
    * 我们再定义 UNIQ(S) 作为字符串 S 中独特字符的个数。
    * 那么，在 S = "LETTER" 中， UNIQ("LETTER") = 2。
    * 对于给定字符串 S，计算其所有非空子串的独特字符的个数（即 UNIQ(substring)）之和。
    * 如果在 S 的不同位置上出现两个甚至多个相同的子串，那么我们认为这些子串是不同的。
    * 考虑到答案可能会非常大，规定返回格式为：结果 mod 10 ^ 9 + 7。
    * 0 \leq S.length \leq 10000
    * */

    public int uniqueLetterString(String S) {
        int length=S.length();
        int[] pos=new int[128];
        int[] dp=new int[length+1];
        int[] time=new int[128];
        Arrays.fill(pos,-1);
        int mod=1000000007;
        int result=0;
        for(int i=0;i<length;i++){
            char cur=S.charAt(i);
            int addTime = i-pos[cur];
            dp[i+1]=(dp[i]+addTime-time[cur])%mod;
            result =(result+dp[i+1])%mod;
            pos[cur]=i;
            time[cur]=addTime;
        }
        return result;
        // Write your code here
    }

    public static void main(String[] args){
        System.out.println(new LINTCODE1440().uniqueLetterString("ABCDABCABA"));
    }
}
