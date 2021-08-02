package LINTCODE7;

import java.util.Arrays;

public class LINTCODE676 {
    /*Description
    * 使用以下映射方式将 A-Z 的消息编码为数字:
    * 'A' -> 1
    * 'B' -> 2
    * ...
    * 'Z' -> 26
    * 除此之外, 编码的字符串也可以包含字符 *, 它代表了 1 到 9 的数字中的其中一个.
    * 给出包含数字和字符 * 的编码消息, 返回所有解码方式的数量. 因为结果可能很大, 所以结果需要对 10^9 + 7 取模
    * */

    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0')
            return 0;
        long[][] dp=new long[s.length()+1][4];
        dp[0][0]=1;
        switch (s.charAt(0)){
            case '0':
                return 0;
            case '1':
                dp[1][1]=1;
                break;
            case '2':
                dp[1][2]=1;
                break;
            case '*':
                dp[1][1]=dp[1][2]=1;
                dp[1][3]=7;
                break;
            default:
                dp[1][3]=1;
        }
        int mod=1000000007;
        for(int i=1;i<s.length();i++){
            switch (s.charAt(i)){
                case '0':
                    long count =dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
                    if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                        dp[i+1][0]=count%mod;
                    }else if(s.charAt(i-1)=='*'){
                        dp[i+1][0]=count*2%mod;
                    }else
                        return 0;
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                    long count1=dp[i][1]+dp[i][2]+dp[i][3]+dp[i][0];
                    long count2 =dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
                    if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                        count1+=count2;
                    }else if(s.charAt(i-1)=='*'){
                        count1+=count2*2;
                    }
                    int index=Math.min(s.charAt(i)-'0',3);
                    dp[i+1][index]=count1%mod;
                    break;
                case '7':
                case '8':
                case '9':
                    long count3=dp[i][1]+dp[i][2]+dp[i][3]+dp[i][0];
                    long count4 =dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
                    if(s.charAt(i-1)=='1'||s.charAt(i-1)=='*'){
                        count3+=count4;
                    }
                    dp[i+1][3]=count3%mod;
                    break;
                default:
                    long c1=dp[i][1]+dp[i][2]+dp[i][3]+dp[i][0];
                    long c2 =dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
                    if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                        c1+=c2;
                    }else if(s.charAt(i-1)=='*'){
                        c1+=c2*2;
                    }
                    dp[i+1][1]=dp[i+1][2]=c1%mod;
                    dp[i+1][3]+=c1*4;
                    long c3=dp[i][1]+dp[i][2]+dp[i][3]+dp[i][0];
                    long c4 =dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3];
                    if(s.charAt(i-1)=='1'||s.charAt(i-1)=='*'){
                        c3+=c4;
                    }
                    dp[i+1][3]+=c3*3;
                    dp[i+1][3]%=mod;
            }
        }
        return (int) ((dp[s.length()][0]+dp[s.length()][1]+dp[s.length()][2]+dp[s.length()][3])%mod);
        // write your code here
    }

}
