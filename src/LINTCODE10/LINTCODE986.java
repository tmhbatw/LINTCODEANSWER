package LINTCODE10;

public class LINTCODE986 {
    /*Description
    *给一个 2D 板, 计数上面有多少战舰. 战舰用 'X' 表示，空地用 '.' 表示。你可以假设有一下规则：
    * 你会得到一个有效的板，上面只有战舰跟空地。
    * 战舰只能横着或者竖着放。换句话说，它们的大小只能是 1xN (1 行, N 列) 或者 Nx1 (N 行, 1 列), N 可以是任意数。
    * 在两艘战舰之间至少有一个横向的或者纵向的格子分隔 - 没有相邻的战舰
    * */

    public int countBattleships(char[][] board) {
        boolean[][] reached=new boolean[board.length][board[0].length];
        int result=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(reached[i][j])
                    continue;
                if(board[i][j]=='X'){
                    result++;
                    int index=i;
                    while(index<board.length-1&&board[index][j]=='X'){
                        index++;
                        reached[index][j]=true;
                    }
                    while(j<board[0].length-1&&board[i][j]=='X')
                        j++;
                }
            }
        }
        return result;
        // Write your code here
    }
}
