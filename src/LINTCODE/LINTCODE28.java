package LINTCODE;

public class LINTCODE28 {
    /*Description
    * Write an efficient algorithm that searches for a value in an m x n matrix.
    * This matrix has the following properties:Integers in each row are sorted from left to right.
    * The first integer of each row is greater than the last integer of the previous row.
    * Challenge
    * O(log(n) + log(m)) time
    * */

    /*Solution
    * 使用两次二分查询发分别查询出target位于哪一行哪一列
    * */

//两次二分法
public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length<1||matrix[0][0]>target)
        return false;
    //第一次二分法查询检索出target位于哪一行
    int up=0,down=matrix.length-1;
    int mid=0;
    while(up<down){
        mid=(up+down)/2;
        if(matrix[mid][0]==target)
            return true;
        if(matrix[mid][0]<target&&(mid==matrix.length-1||matrix[mid+1][0]>target))
            break;
        if(matrix[mid][0]>target)
            down=mid-1;
        if(matrix[mid][0]<target)
            up=mid+1;
        if(up==down)
            mid=up;
    }
    //第二次二分法判断位于哪一列
    int left=0,right=matrix[0].length-1;
    int middle;
    while(left<=right){
        if(left==right)
            return matrix[mid][left]==target;
        middle=(left+right)/2;
        if(matrix[mid][middle]==target)
            return true;
        if(matrix[mid][middle]<target){
            left=middle+1;
        }else{
            right=middle-1;
        }
    }
    return false;
    // write your code here
}




//暴力遍历法
//    public boolean searchMatrix(int[][] matrix, int target) {
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                if (matrix[i][j]==target){
//                    return true;
//                }if(matrix[i][j]>target)
//                    return false;
//            }
//        }
//        return false;
//
//        // write your code here
//    }
}
