package LINTCODE8;

import java.util.Arrays;
import java.util.Locale;

public class LINTCODE725 {
    /*Description
    * 给一带有下列符号的布尔表达式:
    * Symbols
    * 'T' ---> true
    * 'F' ---> false
    * 以及填充在两个符号间的运算符
    * Operators
    * &   ---> boolean AND (位与)
    * |   ---> boolean OR (位或)
    * ^   ---> boolean XOR (异或)
    * 计算在表达式的基础上添加括号使式子为真的方法数.
    * 输入的形式为两个数组, 一个为按顺序给出的符号集(T 和 F), 另一个为运算符(&,|和^)
    * */

    //下为一个jdk12代码，显然对switch语句的使用有一定的优化
    public int countParenth(char[] symb, char[] oper) {
        int length=symb.length;
        int[][][] dp=new int[length][length][2];
        for(int i=0;i<length;i++){
            if(symb[i]=='T')
                dp[i][i][0]=1;
            else
                dp[i][i][1]=1;
        }
        for(int l=1;l<length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                for(int k=i;k<j;k++){
                    switch (oper[k]) {
                        case '&' -> {
                            dp[i][j][0] += dp[i][k][0] * dp[k + 1][j][0];
                            dp[i][j][1] += dp[i][k][1] * (dp[k + 1][j][0] + dp[k + 1][j][1]) + dp[i][k][0] * dp[k + 1][j][1];
                        }
                        case '|' -> {
                            dp[i][j][1] += dp[i][k][1] * dp[k + 1][j][1];
                            dp[i][j][0] += dp[i][k][0] * (dp[k + 1][j][0] + dp[k + 1][j][1]) + dp[i][k][1] * dp[k + 1][j][0];
                        }
                        default -> {
                            dp[i][j][0] += dp[i][k][0] * dp[k + 1][j][1] + dp[i][k][1] * dp[k + 1][j][0];
                            dp[i][j][1] += dp[i][k][0] * dp[k + 1][j][0] + dp[i][k][1] * dp[k + 1][j][1];
                        }
                    }
                }
            }
        }
        return dp[0][length-1][0];
        // write your code here
    }

    public static void main(String[] args){
        String s1="TFFF";
        String s2=        "^|&";
        System.out.println(new LINTCODE725().countParenth(s1.toCharArray(),s2.toCharArray()));

    }
}
