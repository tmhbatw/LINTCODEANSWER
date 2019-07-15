package LINTCODE8;

import datastructure.ParentTreeNode;

public class LINTCODE746 {
    /*Description
    *设计井字棋游戏。
    * 棋盘的尺寸为3
    * X 总是先行动走出第一步
    * 如果一个位置已经被占，且一名玩家打算占领该位置，一个AlreadyTakenException信息将被抛出
    * 如果一名玩家胜利，且有玩家打算继续行动，一个GameEndException信息将被抛出
    * 如果所有的地方都已被占领，你需要输出"it's a draw"
    * */

    /*Solution
    * 关于赢或输以及怎样重新开始定义得一塌糊涂
    * */

    class GameEndException extends Exception{
        public GameEndException()
        {
            super("Game has been ended, cannot make any more moves");
        }
    }

    class AlreadyTakenException extends Exception {
        public AlreadyTakenException()
        {
            super("This place has been taken");
        }
    }

    class TicTacToe {
        char[][] checkerboard;
        char curr;
        int time;
        boolean win;
        public TicTacToe() {
            initial();
        }

        public void initial(){
            this.checkerboard=new char[3][3];
            this.curr='X';
            this.time=0;
            this.win=false;
        }
        public void changePlayer(){
            curr=curr=='X'?'O':'X';
        }

        public boolean fullBoard(){
            return time==9;
        }

        public boolean playerWin(int row,int col){
            if(checkerboard[row][0]==checkerboard[row][1]&&checkerboard[row][1]==checkerboard[row][2])
                return true;
            if(checkerboard[0][col]==checkerboard[1][col]&&checkerboard[1][col]==checkerboard[2][col])
                return true;
            if(checkerboard[0][0]==checkerboard[1][1]&&checkerboard[1][1]==checkerboard[2][2])
                return true;
            if(checkerboard[0][2]==checkerboard[1][1]&&checkerboard[1][1]==checkerboard[2][0])
                return true;
            return false;
        }

        public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
            if(win) {
                initial();
                throw new GameEndException();
            }
            if(checkerboard[row][col]=='X'||checkerboard[row][col]=='O')
                throw new AlreadyTakenException();
            if(fullBoard()){
                System.out.println("it's a draw");
            }
            time++;
            checkerboard[row][col]=curr;
            changePlayer();
            win= playerWin(row,col);
            boolean currr=win;
            if(currr){
                System.out.println(curr+" "+"player wins!");
                this.checkerboard=new char[3][3];
                this.curr='X';
                this.time=0;
                this.win=false;
            }
            return currr;
        }
    }
}
