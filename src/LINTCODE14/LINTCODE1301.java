package LINTCODE14;

public class LINTCODE1301 {
    /*Description
    * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
    * 每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。
    * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
    * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
    * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
    * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
    * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
    * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。
    * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
    * */

    public void gameOfLife(int[][] board) {
        int[][] result=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int curNumber=0;
                curNumber+=i>=1&&j>=1&&board[i-1][j-1]==1?1:0;
                curNumber+=i>=1&&board[i-1][j]==1?1:0;
                curNumber+=i>=1&&j<board[0].length-1&&board[i-1][j+1]==1?1:0;
                curNumber+=j>=1&&board[i][j-1]==1?1:0;
                curNumber+=j<board[0].length-1&&board[i][j+1]==1?1:0;
                curNumber+=i<board.length-1&&j>=1&&board[i+1][j-1]==1?1:0;
                curNumber+=i<board.length-1&&board[i+1][j]==1?1:0;
                curNumber+=i<board.length-1&&j<board[0].length-1&&board[i+1][j+1]==1?1:0;
                if(curNumber==3||curNumber==2&&board[i][j]==1)
                    result[i][j]=1;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
                board[i][j]=result[i][j];
        }
        // Write your code here
    }
}
