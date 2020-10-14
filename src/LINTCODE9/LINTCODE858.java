package LINTCODE9;

public class LINTCODE858 {
    /*Description
    * 这个问题是要实现糖果粉碎传奇的基本消除算法。
    * 给出一个二维的整数数组board，它表示一个糖果棋盘，棋盘中board[i][j]不同的正整数表示不同种类的糖果，
    * board[i][j] = 0表示位置(i, j)是空的。给出的棋盘是玩家执行某一步操作后的状态。现在，你需要根据以下规则消除糖果，并将棋盘恢复到稳定的状态：
    * 如果三个或者三个以上相同类型的糖果在横向或者纵向相连，同时消除它们，这些糖果的位置变为空。
    * 在同时消除所有糖果后，如果空的位置上方有糖果，这些糖果会掉下来，直到他们碰到下方的糖果或者棋盘底部（不会从棋盘上边界掉下新的糖果）。
    * 执行完以上步骤后，可能会有新的可以消除的糖果。如果有新的可以被消除的糖果，则重复以上步骤。
    * 如果没有新的可以被消除的糖果（也就是说，棋盘是稳定的状态），返回当前的棋盘。
    * 你需要执行以上的规则，直到棋盘稳定，然后返回稳定的棋盘。
    * */

    public int[][] candyCrush(int[][] board) {
        int row=board.length,col=board[0].length;
        boolean[][] remove=new boolean[row][col];
        boolean flag=false;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==0)
                    continue;
                int time=1;
                while(j<col-1&&board[i][j+1]==board[i][j]) {
                    time++;
                    j++;
                }
                if(time>=3){
                    flag=true;
                    for(int k=j-time+1;k<=j;k++)
                        remove[i][k]=true;
                }else{
                    j-=time-1;
                }
            }
        }
        for(int j=0;j<col;j++){
            for(int i=0;i<row;i++){
                if(board[i][j]==0)
                    continue;
                int time=1;
                while(i<row-1&&board[i+1][j]==board[i][j]){
                    i++;
                    time++;
                }
                if(time>=3){
                    flag=true;
                    for(int k=i-time+1;k<=i;k++){
                        remove[k][j]=true;
                    }
                }else{
                    i-=time-1;
                }
            }
        }
        if(!flag)
            return board;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(remove[i][j])
                    board[i][j]=0;
            }
        }
        return candyCrush(getNextPos(board));
        // Write your code here
    }

    //用来糖果下落的方法
    private int[][] getNextPos(int[][] board){
        int row=board.length;
        for(int i=0;i<board[0].length;i++){
            int index=row-1;
            for(int j=row-1;j>=0;j--){
                if(board[j][i]==0){
                    index=Math.min(index,j);
                    index--;
                    while(index>=0&&board[index][i]==0)
                        index--;
                    if(index<0)
                        break;
                    board[j][i]=board[index][i];
                    board[index][i]=0;
                }
            }
        }
        return board;
    }
}
