package LINTCODE5;

import java.util.Arrays;

public class LINTCODE405 {

    /*Description
    *给定一个整数矩阵，请找出一个子矩阵，使得其数字之和等于0.输出答案时，请返回左上数字和右下数字的坐标。
    * 如果有多个答案, 你可以返回其中任意一个.
    * */

    /*Solution
    * 建立一个数组用来保存前i行j列的数字之和
    * o(n4)时间复杂度可以轻松解决
    * */

    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        int[][] res = new int[2][2];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = matrix[i - 1][j - 1] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int[] start = {i - 1, j - 1};
                for (int k = i; k <= m; k++) {
                    for (int l = j; l <= n; l++) {
                        int[] end = {k - 1, l - 1};
                        if (sum[k][l] - sum[k][j - 1] - sum[i - 1][l] + sum[i - 1][j - 1] == 0) {
                            res[0] = start;
                            res[1] = end;
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }
}
