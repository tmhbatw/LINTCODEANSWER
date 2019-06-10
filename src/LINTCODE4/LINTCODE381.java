package LINTCODE4;

public class LINTCODE381 {

    /*Description
    *Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
    * (The spiral rotates clockwise from the outside to the inside, referring to examples)
    * */

    /*Solution
    * 按顺序将数字写入到数组中即可
    * */

    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int index=1;
        int judge=0;
        while(judge<(n+1)/2){

            if(judge==n/2) {
                result[judge][judge]=index++;
                break;
            }
            for(int i=judge;i<n-1-judge;i++)
                result[judge][i]=index++;
            for(int i=judge;i<n-1-judge;i++)
                result[i][n-1-judge]=index++;
            for(int i=n-1-judge;i>judge;i--)
                result[n-1-judge][i]=index++;
            for(int i=n-1-judge;i>judge;i--)
                result[i][judge]=index++;
            judge++;
        }
        return result;
        // write your code here
    }
}
