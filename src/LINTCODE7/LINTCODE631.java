package LINTCODE7;

public class LINTCODE631 {
    /*Description
    *给出一个只有 0 和 1 组成的二维矩阵，找出最大的一个子矩阵，使得这个矩阵对角线上全是 1 ，其他位置全是 0 .
    * */

    public int maxSquare2(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp1=new int[row][col];//上三角全为0
        int[][] dp2=new int[row][col];//下三角全为0
        int[][] dp3=new int[row][col];//对角线全为1
        int result=0;
        for(int j=0;j<col;j++){
            if(matrix[0][j]==0){
                dp1[0][j]=1;
                dp2[0][j]=1;
            }else {
                dp3[0][j] = 1;
                result=1;
            }
        }
        for(int i=1;i<row;i++){
            if(matrix[i][0]==0){
                dp1[i][0]=1;
                dp2[i][0]=1;
            }else{
                dp3[i][0]=1;
                result=1;
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    dp1[i][j]=Math.min(dp1[i-1][j],dp1[i-1][j-1])+1;
                    dp2[i][j]=Math.min(dp2[i][j-1],dp2[i-1][j-1])+1;
                }else{
                    dp3[i][j]=dp3[i-1][j-1]+1;
                    result=Math.max(result,Math.min(dp3[i][j],Math.min(dp1[i-1][j],dp2[i][j-1])+1));
                }
            }
        }
        return result;
        // write your code here
    }
}
