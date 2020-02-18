package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1156 {
    /*Description
    * 给定 word1 和 word2 两个单词，找到使 word1 和 word2 相同所需的最少步骤，
    * 每个步骤可以删除任一字符串中的一个字符。
    * */

    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word2.length()][word1.length()+1];
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)==word2.charAt(0)){
                while(i< word1.length())
                    dp[0][i+++1]=1;
            }
        }
        for(int i=1;i<word2.length();i++){
            char curTarget=word2.charAt(i);
            for(int j=0;j<word1.length();j++){
                dp[i][j+1]=Math.max(dp[i-1][j+1],dp[i][j+1]);
                if(word1.charAt(j)==curTarget){
                    int index=j;
                    int time=dp[i-1][j]+1;
                    while(index<word1.length()){
                        dp[i][index+1]=Math.max(dp[i][index+++1],time);
                    }
                }
            }
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        int max=dp[word2.length()-1][word1.length()];
        return word1.length()+word2.length()-max-max;
        // write your code here
    }


}
