package LINTCODE12;

public class LINTCODE1146 {
    /*Description
    * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),
    * 现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色
    * 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个
    * */

    public int[][] ChessPieceRotation(int[][] A, int[][] F) {
        for(int[] cur:F){
            if(cur[0]!=1)
                change(A,cur[0]-1,cur[1]);
            if(cur[0]!=4)
                change(A,cur[0]+1,cur[1]);
            if(cur[1]!=1)
                change(A,cur[0],cur[1]-1);
            if(cur[1]!=4)
                change(A,cur[0],cur[1]+1);
        }
        return A;
        // write your code here
    }

    private void change(int[][] A,int x,int y){
        x--;
        y--;
        A[x][y]=1-A[x][y];
    }
}
