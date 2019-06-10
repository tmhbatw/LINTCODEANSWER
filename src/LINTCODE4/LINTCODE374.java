package LINTCODE4;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE374 {
    /*Description
    * 给定一个包含 m x n 个要素的矩阵，（m 行, n 列），按照螺旋顺序，返回该矩阵中的所有要素。
    * */

    /*Solution
    * 按照其要求的顺序遍历输出即可
    * */

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0 ) return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int xMin = 0;
        int yMin = 0;
        int xMax = matrix[0].length - 1;
        int yMax = matrix.length - 1;

        result.add(matrix[0][0]);

        int i = 0, j = 0;
        while (true) {
            while (i < xMax)    result.add(matrix[j][++i]);
            if (++yMin > yMax)    break;

            while (j < yMax)    result.add(matrix[++j][i]);
            if (xMin > --xMax)    break;

            while (i > xMin)    result.add(matrix[j][--i]);
            if (yMin > --yMax)    break;

            while (j > yMin)    result.add(matrix[--j][i]);
            if (++xMin > xMax)    break;
        }
        return result;
    }
}
