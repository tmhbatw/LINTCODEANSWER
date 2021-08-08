package LINTCODE14;

public class LINTCODE1330 {
    /*Description
    * 给定一个非负二维矩阵Matrix，元素均大于等于0
    * 问是否存在c行d列 元素都为0 的子矩阵
    * */

    public boolean isZeroMatrix(int[][] Matrix, int c, int d) {
        int[] count=new int[Matrix[0].length];
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j<Matrix[0].length;j++){
                if(Matrix[i][j]==0){
                    count[j]+=1;
                }else{
                    count[j]=0;
                }
            }
            int[] dp=new int[Matrix[0].length+1];
            for(int j=0;j<Matrix[0].length;j++){
                if(count[j]>=c){
                    dp[j+1]=dp[j]+1;
                    if(dp[j+1]>=d)
                        return true;
                }else{
                    dp[j+1]=0;
                }
            }
        }
        return false;
        // write your code here
    }
}
