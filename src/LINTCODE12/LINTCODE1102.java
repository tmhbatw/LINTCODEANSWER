package LINTCODE12;

public class LINTCODE1102 {
    /*Description
    *包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
    * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
    * */

    public int[][] imageSmoother(int[][] M) {
        int[][] result=new int[M.length][M[0].length];
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                int[] near=new int[8];
                int time=1;
                if(i-1>=0&&j-1>=0){
                    near[0]=M[i-1][j-1];
                    time++;
                }
                if(i-1>=0) {
                    near[1] = M[i - 1][j];
                    time++;
                }
                if(i-1>=0&&j+1<M[0].length){
                    near[2]=M[i-1][j+1];
                    time++;
                }
                if(j-1>=0) {
                    near[3] =M[i][j - 1];
                    time++;
                }
                if(j+1<M[0].length) {
                    near[4] =M[i][j + 1];
                    time++;
                }
                if(i+1<M.length&&j-1>=0) {
                    near[5] =M[i + 1][j - 1];
                    time++;
                }
                if(i+1<M.length) {
                    near[6] =M[i + 1][j];
                    time++;
                }
                if(i+1<M.length&&j+1<M[0].length) {
                    near[7] =M[i + 1][j + 1];
                    time++;
                }
                int curSum=M[i][j];
                for(int cur:near)
                    curSum+=cur;
                result[i][j]=curSum/time;
            }
        }
        return result;
        // Write your code here
    }
}
