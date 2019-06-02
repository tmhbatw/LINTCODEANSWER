package LINTCODE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE132 {
    /*Description
    * Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix.
    * A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary
    * */

    /*Solution
    * 与123题一毛一样
    * */
    private boolean result=false;
    public List<String> wordSearchII(char[][] board, List<String> words) {

        List<String> res=new ArrayList<>();
        for(int i=0;i<words.size();i++){
            result=false;
            if(exist(board,words.get(i)))
                res.add(words.get(i));
        }
        return res;
        // write your code here
    }

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
