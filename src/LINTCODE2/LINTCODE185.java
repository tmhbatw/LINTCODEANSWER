package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE185 {
    /*Description
    * 给你一个包含 m x n 个元素的矩阵 (m 行, n 列), 求该矩阵的之字型遍历。
    * */

    /*Solution
    * 按Z字顺序输出即可
    * 很烦的题
    * */

    public int[] printZMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return null;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        int i = 0, j = 0;
        while (true) {
            while (i >= 0 && j < matrix[0].length) {
                result[index++] = matrix[i--][j++];
            }
            if (index == result.length)
                return result;
            if (j < matrix[0].length)
                i--;
            else {
                i = i + 2;
                j--;
            }
            while (i < matrix.length && j >= 0) {
                result[index++] = matrix[i++][j--];
            }
            if (index == result.length)
                return result;
            if (i < matrix.length) {
                j = j + 1;
            } else {
                i++;
                j = j + 2;
            }
        }
    }
}
