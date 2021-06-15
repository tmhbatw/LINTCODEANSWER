package LINTCODE15;

public class LINTCODE1489 {
    /*Description
    * 给定一个大小n∗m的矩阵arr，从arr中找出一个非空子矩阵，使位于这个子矩阵边界上的元素之和最大。
    * 输出该子矩阵的边界上的元素之和。
    * */

    public int solve(int[][] arr) {
        int result=Integer.MIN_VALUE;
        int m=arr.length,n=arr[0].length;
        int[][] rowVal=new int[m+1][n];
        int[][] colVal=new int[m][n+1];
        for(int i=0;i<m;i++){
            int minPre=0;
            for(int j=0;j<n;j++) {
                colVal[i][j + 1] = arr[i][j] + colVal[i][j];
                result=Math.max(colVal[i][j+1]-minPre,result);
                minPre=Math.min(minPre,colVal[i][j+1]);
            }
        }
        for(int j=0;j<n;j++){
            int minPre=0;
            for(int i=0;i<m;i++){
                rowVal[i+1][j]=arr[i][j]+rowVal[i][j];
                result=Math.max(rowVal[i+1][j]-minPre,result);
                minPre=Math.min(minPre,rowVal[i+1][j]);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int x=i+1;x<m;x++){
                    for(int y=j+1;y<n;y++){
                        result=Math.max(result,colVal[i][y+1]-colVal[i][j]+colVal[x][y+1]-colVal[x][j]
                                +rowVal[x][j]-rowVal[i+1][j]+rowVal[x][y]-rowVal[i+1][y]);
                    }
                }
            }
        }
        return result;
        // Write your code here
    }
}
