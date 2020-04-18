package LINTCODE11;

public class LINTCODE1022 {
    /*Description
    * 一个井字棋盘以字符串数组 board的形式给出。返回true当且仅当在一个合法的井字棋游戏当中可能到达当前这种棋盘情况。
    * board是一个 3 x 3 的数组， 包含字符 ' ', 'X', 和'O'。字符 ' '意味着这一格是空的。
    * 以下是井字棋的游戏规则：
    * 玩家需要轮流在空格上放置字符。
    * 第一个玩家总是放置'X'字符，第二个玩家总是放置'O'字符。
    * 'X' 和 'O' 总是被放置在空格上，不能放置在已有字符的格子上。
    * 当有3格相同的（非空）字符占据一行、一列或者一个对角线的时候，游戏结束。
    * 当所有格子都非空的时候游戏也结束。
    * 游戏结束后不允许多余操作。
    * */

    public boolean validTicTacToe(String[] board) {
        char[][] b=new char[3][3];
        for(int i=0;i<3;i++)
            b[i]=board[i].toCharArray();
        boolean XWin=getWin('X',b);
        boolean OWin=getWin('O',b);
        int XTime=getTime('X',b);
        int OTime=getTime('O',b);
        if(XWin&&OWin)
            return false;
        if(XWin&&XTime-OTime==1||OWin&&XTime==OTime)
            return true;
        if(XWin||OWin)
            return false;
        return OTime==XTime||XTime-OTime==1;
        // Write your code
    }

    private int getTime(char cur,char[][] b){
        int time=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(b[i][j]==cur)
                    time++;
            }
        }
        return time;
    }

    private boolean getWin(char cur,char[][] b){
        for(int i=0;i<3;i++){
            if(b[i][0]==cur&&b[i][1]==cur&&b[i][2]==cur||b[0][i]==cur&&b[1][i]==cur&&b[2][i]==cur)
                return true;
        }
        if(b[0][0]==cur&&b[1][1]==cur&&b[2][2]==cur||b[0][2]==cur&&b[1][1]==cur&&b[2][0]==cur)
            return true;
        return false;
    }
}
