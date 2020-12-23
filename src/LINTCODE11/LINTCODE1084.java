package LINTCODE11;

import java.math.BigDecimal;

public class LINTCODE1084 {
    /*Description
    * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。
    * 即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。
    * 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。
    * 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
    *现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
    * 求移动结束后，“马” 仍留在棋盘上的概率。
    *  */

    public double knightProbability(int N, int K, int r, int c) {
        double[][] cur=new double[N][N];
        cur[r][c]=1.0;
        int[][] pos=new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-2,-1},{-1,-2},{-2,1},{-1,2}};
        while(K-->0){
            double[][] curr=new double[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(cur[i][j]==0)
                        continue;
                    double time=cur[i][j];
                    for(int[] nextPos:pos){
                        int ii=i+nextPos[0],jj=j+nextPos[1];
                        if(ii<N&&ii>=0&&jj<N&&jj>=0){
                            curr[ii][jj]+=time/8;
                        }
                    }
                }
            }
            cur=curr;
        }
        double result=0.0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                result+=cur[i][j];
        }
        return result;
        // Write your code here.
    }

    public static void main(String[] args){
        double result=1.0;
        for(int i=0;i<100;i++){
            result/=8;
        }
        System.out.println(result);
    }
}
