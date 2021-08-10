package LINTCODE13;

import java.util.Arrays;
import java.util.TreeSet;

public class LINTCODE1278 {
    /*Description
    * 给定一个非空的二维矩阵 matrix 和一个整数 k，找出 matrix 中的一个矩形，
    * 该矩形内的元素之和最大并且不超过 k，返回这个最大和。
    * */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result=Integer.MIN_VALUE;
        for(int start =0;start<matrix.length;start++) {
            int[] cur=new int[matrix[0].length+1];
            for (int i = start; i < matrix.length; i++) {
                int[] sum = new int[matrix[0].length + 1];
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int j = 0; j < matrix[0].length; j++) {
                    cur[j + 1] += matrix[i][j];
                    sum[j + 1] = cur[j + 1] + sum[j];
                    if (set.ceiling(sum[j + 1] - k) != null) {
                        result = Math.max(sum[j + 1] - set.ceiling(sum[j + 1] - k), result);
                    }
                    set.add(sum[j + 1]);
                }
            }
        }
        return result;
        // Write your code here
    }
    public static void main(String[] args){
        TreeSet<Integer> set=new TreeSet();
        set.add(3);
        set.add(1);
    }
}
