package LINTCODE2;

import java.util.Date;

public class LINTCODE108 {

    /*Description
    * 给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.
    * 最少需要分割几次?
    * */

    /*Solution
    * 递归回溯算法尝试一下时间复杂度超出
    * 只能选择动态规划
    * 创建一个二维dp数组用来保存字符串从第i位到第j位是否为回文字符串
    * 创建一个result数组用来保存最小的分割次数
    * 动态规划可以获得结果的值
    * */


    public int minCut(String s) {
        int[][] dp=new int[s.length()][s.length()];

        //result[i]表示从最后到第i位的最小切割数
        int[] result=new int[s.length()+1];
        for(int i=s.length()-1;i>=0;i--){
            result[i]=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)&&((j-i)<=1||dp[i+1][j-1]==1)) {
                    dp[i][j] = 1;
                    //当从i到j可以翻转时
                    result[i]=Math.min(result[i],1+result[j+1]);
                }
            }
        }

        //因为result[s.length()]多加了1；
        return result[0]-1;


        // write your code here
    }



/*    private static int min=Integer.MAX_VALUE;
    public static int minCut(String s) {
        if(s.length()==0)
            return 0;
        recursion(s,0);
        return min;
        // write your code here
    }

    public static void recursion(String s,int time){
        if(palindrome(s)){
            min=Math.min(min,time);
            System.out.println(min);
            return;
        }

        for(int i=s.length()-1;i>0;i--){
            String curr=s.substring(0,i);
            if(palindrome(curr)){
                recursion(s.substring(i,s.length()),time+1);
            }
        }

    }

    public static boolean  palindrome(String s){
        return s.equals(new StringBuffer(s).reverse().toString());
    }*/






}
