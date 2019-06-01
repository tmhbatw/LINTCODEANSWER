package LINTCODE2;

import java.util.Arrays;

public class LINTCODE123 {
    /*Description
    * 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
    * 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。每个单元中的字母最多只能使用一次。
    * */

    /*Solution
    * 找到开始字符位于字符数组中的位置，从这个位置上下左右进行四个方向的遍历
    * 当遍历到完整的目标字符串时结束遍历并保存结果为true
    * 当已有结果为真时跳出递归
    * */

    private boolean result=false;
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)
            return true;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    recursion(board,i,j,word,1);
                }
            }
        }
        return result;
        // write your code here
    }
    private void recursion(char[][] board,int i,int j,String word,int index){
        if(result==true)
            return;
        if(index==word.length()){
            result=true;
            return ;
        }
        char[][] boa=new char[board.length][board[0].length];
        for(int m=0;m<boa.length;m++){
            boa[m]= Arrays.copyOf(board[m],boa[m].length);
        }
        boa[i][j]=' ';
        if(i>=1&&boa[i-1][j]==word.charAt(index))
            recursion(boa,i-1,j,word,index+1);
        if(j>=1&&boa[i][j-1]==word.charAt(index))
            recursion(boa,i,j-1,word,index+1);
        if(i<board.length-1&&boa[i+1][j]==word.charAt(index))
            recursion(boa,i+1,j,word,index+1);
        if(j<board[0].length-1&&boa[i][j+1]==word.charAt(index))
            recursion(boa,i,j+1,word,index+1);

    }
}
