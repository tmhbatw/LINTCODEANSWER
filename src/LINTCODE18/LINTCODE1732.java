package LINTCODE18;

import com.sun.org.apache.xerces.internal.dom.AbortException;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1732 {
    /*Description
    *在一块 N x N 的棋盘 board 上，从棋盘的左下角开始，每一行交替方向，按从 1 到 N*N 的数字给方格编号。例如，对于一块 6 x 6 大小的棋盘，可以编号如下：
    * 图片
    * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
    * 每一次从方格 x 起始的移动都由以下部分组成：
    * 你选择一个目标方块 S，它的编号是 x+1，x+2，x+3，x+4，x+5，或者 x+6，只要这个数字 <= N*N。
    * 如果 S 有一个蛇或梯子，你就移动到那个蛇或梯子的目的地。否则，你会移动到 S。
    * 在 r 行 c 列上的方格里有 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
    * 注意，你每次移动最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
    * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
    * */

    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int N=n*n;
        boolean[] reached=new boolean[N+1];
        int first=getPos(1,board);
        reached[1]=true;
        int step=-1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            step++;
            int size=queue.size();
            while(size-->0){
                int cur=queue.poll();
                if(cur==N)
                    return step;
                for(int i=1;i<=6;i++){
                    cur++;
                    int curr=getPos(cur,board);
                    if(curr==-1)
                        curr=cur;

                    //System.out.println(cur+" "+curr+" "+step);
                    if(curr==N)
                        return step+1;
                    if(reached[curr])
                        continue;
                    reached[curr]=true;
                    queue.add(curr);
                }
            }
        }
        return -1;
        //
    }


    private int getPos(int cur,int[][] board){
        int n=board.length;
        int row=(cur-1)/n,col=(cur-1)%n;
        row=n-row-1;
        if(row%2==n%2)
            col=n-col-1;
        //System.out.println(cur+" "+row+" "+col+" "+board[row][col]);
        return board[row][col];
    }
}
