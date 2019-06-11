package LINTCODE4;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE389  {

    /*Description
    * 请判定一个数独是否有效。
    * 该数独可能只填充了部分数字，其中缺少的数字用 . 表示。
    * */

    /*Solution
    *可以使用hashmap用来存储每一行、每一列、每一个九宫格的九个数字，从而判断是否有数字出现了重复情况
    * */


    public boolean isValidSudoku(char[][] board) {
        Map<Integer,HashMap> row=new HashMap<>();
        Map<Integer,HashMap> col=new HashMap<>();
        Map<Integer,HashMap> box=new HashMap<>();
        for(int i=0;i<=0;i++){
            row.put(i,new HashMap<Character,Integer>());
            col.put(i,new HashMap<Character,Integer>());
            box.put(i,new HashMap<Character,Integer>());
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.')
                    continue;
                char curr=board[i][j];
                HashMap<Character,Integer> currRow=row.get(i);
                HashMap<Character,Integer> currCol=col.get(j);
                HashMap<Character,Integer> currBox=box.get(i/3+j/3*3);
                if(currRow.containsKey(curr)||currCol.containsKey(curr)||currBox.containsKey(curr))
                    return false;
                currRow.put(curr,1);
                currCol.put(curr,1);
                currBox.put(curr,1);
            }
        }
        return true;

        // write your code here
    }


}
