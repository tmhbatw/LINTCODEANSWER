package LINTCODE5;

import java.util.ArrayList;
import java.util.Stack;

public class LINTCODE477 {
    /*Description
    *给一个二维的矩阵，包含 'X' 和 'O', 找到所有被 'X' 围绕的区域，并用 'X' 替换其中所有的 'O'。
    * */

    /*Solution
    * 创建一个数组用来存储当前的节点是否遍历过遍历每一个节点——此方法太睿智了
    * 可以从边缘开始遍历，与边缘相连则为’O',其他均为‘X';
    * */

    public static int[][] near=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void surroundedRegions(char[][] board) {
        if(board.length<=1)
            return ;
        boolean[][] searched=new boolean[board.length][board[0].length];
        for(int i=1;i<board.length-1;i++){
            if(board[i][0]=='O')
                recursion(board,searched,i,0);
            if(board[i][board[0].length-1]=='O')
                recursion(board,searched,i,board[0].length-1);
        }
        for(int j=1;j<board[0].length-1;j++){
            if(board[0][j]=='O')
                recursion(board,searched,0,j);
            if(board[board.length-1][j]=='O')
                recursion(board,searched,board.length-1,j);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='+')
                    board[i][j]='O';
                if(board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }

    private void recursion(char[][] board,boolean[][] searched,int i,int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='X'||searched[i][j])
            return;
        searched[i][j]=true;
        board[i][j]='+';
        for(int[] curr:near){
            recursion(board,searched,i+curr[0],j+curr[1]);
        }
    }



/*    boolean isO=false;
    public static int[][] near=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};


    public void surroundedRegions(char[][] board) {
        if(board.length==0)
            return;
        boolean[][] searched=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'||searched[i][j])
                    continue;
                boolean[][] stack=new boolean[board.length][board[0].length];
                isO=false;
                recursion(stack,board,searched,i,j);
                if(!isO){
                    for(int m=0;m<stack.length;m++){
                        for(int n=0;n<stack[0].length;n++){
                            if(stack[m][n])
                                board[m][n]='X';
                        }
                    }
                }
            }
        }
        // write your code here
    }

    private void recursion(boolean[][] stack,char[][] board,boolean[][] searched,int i, int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='X'||searched[i][j])
            return;
        stack[i][j]=true;
        searched[i][j]=true;
        if(i==0||i==board.length-1||j==0||j==board[0].length-1){
            isO=true;
        }
        for(int[] curr:near){
            recursion(stack,board,searched,i+curr[0],j+curr[1]);
        }
    }

    class Point{
        int x, y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }*/
}
