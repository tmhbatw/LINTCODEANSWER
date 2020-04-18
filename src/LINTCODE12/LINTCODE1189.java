package LINTCODE12;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1189 {
    /*Description
    * 让我们一起来玩扫雷游戏！
    * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，
    * 和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
    * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
    * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
    * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
    * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
    * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
    * */

    class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    int[][] near=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        int m=board.length;
        int n=board[0].length;
        int startMineNumber=getMineNumber(click[0],click[1],board);
        if(startMineNumber!=0){
            board[click[0]][click[1]]=(char)(startMineNumber+'0');
            return board;
        }
        Queue<Point> queue=new LinkedList<>();
        queue.add(new Point(click[0],click[1]));
        while(!queue.isEmpty()){
            Point cur=queue.poll();
            int x=cur.x,y=cur.y;
            for(int[] curNear:near){
                int xx=x+curNear[0];
                int yy=y+curNear[1];
                if(xx>=0&&yy>=0&&xx<m&&yy<n&&board[xx][yy]=='E'){
                    int mineNumber=getMineNumber(xx,yy,board);
                    if(mineNumber==0){
                        board[xx][yy]='B';
                        queue.add(new Point(xx,yy));
                    }else{
                        board[xx][yy]=(char)(mineNumber+'0');
                    }
                }
            }
        }
        return board;
        // Write your code here
    }

    private int getMineNumber(int x,int y,char[][] board){
        int m=board.length;
        int n=board[0].length;
        int result=0;
        for(int[] curNear:near){
            int mm=x+curNear[0];
            int nn=y+curNear[1];
            if(mm>=0&&nn>=0&&mm<m&&nn<n&&board[mm][nn]=='M')
                result++;
        }
        return result;
    }
}
