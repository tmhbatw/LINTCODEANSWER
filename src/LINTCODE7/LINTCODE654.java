package LINTCODE7;

public class LINTCODE654 {
    /*Description
    * 给定两个 稀疏矩阵 A 和 B，返回AB的结果。
    * 您可以假设A的列数等于B的行数。
    * */

    public int[][] multiply(int[][] A, int[][] B) {
        int length=A[0].length;
        int[][] result=new int[A.length][A[0].length];
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                for(int k=0;k<length;k++){
                    result[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return result;
        // write your code here
    }
}
