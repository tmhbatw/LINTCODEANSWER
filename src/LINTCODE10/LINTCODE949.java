package LINTCODE10;

import java.util.Arrays;

public class LINTCODE949 {
    /*Description
    * 在斐波那契数列中，F0 = 0, F1 = 1, 和 Fn = Fn − 1 + Fn − 2 对于 n ≥ 2。举一个例子，斐波那契数列中前十项为: 0,1,1,2,3,5,8,13,21,34。
    * 一个斐波那契数列的公式：对于一个给定的整数n，你的目标就是输出Fn的末尾4位数字   * */

    public int lastFourDigitsOfFn(int n) {
        if(n==0)
            return 0;
        int[][] res=new int[][]{{1,0},{0,1}};
        int[][] matrix=new int[][]{{1,1},{1,0}};
        while(n>0){
            int count=n%2;
            if(count==1)
                res=matrixMultiply(res,matrix);
            n/=2;
            matrix=matrixMultiply(matrix,matrix);
        }
        return res[0][0];
        // write your code here
    }

    private int getRes(int n){
        int f1=0;
        int f2=1;
        for(int i=2;i<=n;i++){
            int temp=f1+f2;
            f1=f2;
            f2=temp;
        }
        return f2;
    }

    private int[][] matrixMultiply(int[][] matrix,int[][] cur){
        int mod=10000;
        int[][] res=new int[2][2];
        res[0][0]=(matrix[0][0]*cur[0][0]+matrix[0][1]*cur[1][0])%mod;
        res[0][1]=(matrix[0][0]*cur[0][1]+matrix[0][1]*cur[1][1])%mod;
        res[1][0]=(matrix[1][0]*cur[0][0]+matrix[1][1]*cur[1][0])%mod;
        res[1][1]=(matrix[1][0]*cur[0][1]+matrix[1][1]*cur[1][1])%mod;
        return res;
    }

    public static void main(String[] args){
        System.out.println(new LINTCODE949().getRes(3000));
    }
}
