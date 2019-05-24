package LINTCODE;

public class LINTCODE38 {
    /*Description
    *Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
    * This matrix has the following properties:
    *   Integers in each row are sorted from left to right.
    *   Integers in each column are sorted from up to bottom.
    * No duplicate integers in each row or column.
    * Challenge
    * O(m+n) time and O(1) extra space
    * */

    /*Solution
    * 可以从数组的左下角开始寻找，如果目标较大，则向右搜索，如果目标较小，则向上搜索
    * 若相等，则向右上寻找
    * */
    public int searchMatrix(int[][] matrix, int target) {
        int result=0;
        int i=matrix.length-1,j=0;//从左下角开始寻找
        while(i>=0&&j<matrix[0].length){
            if(matrix[i][j]<target){
                i++;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                result++;
                i++;
                j--;
            }
        }
        return result;
    }
}
