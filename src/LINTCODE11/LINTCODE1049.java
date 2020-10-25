package LINTCODE11;

import java.util.*;

public class LINTCODE1049 {
    /*Description
    * 假设我们要用一些方块搭建金字塔，每个方块对应仅含一个字母的字符串，例如“Z”。
    * 对于方块“C”，我们并不把它放在下方，而是把它作为左方块“A”和右方块“B”的上一层，这个三元组用(A, B, C)表示，
    * 只有符合要求的三元组才可以用来堆砌金字塔。
    * 现在，给定最底层bottom，用一个字符串表示，再给出所有符合要求的的三元组allowed，每个三元组用一个长度为3的字符串表示。
    * 如果可以将金字塔构建至顶端，则返回true，否则返回false。
    * */
    boolean result=false;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        boolean[][][] exist=new boolean[26][26][26];
        for(String cur:allowed){
            exist[cur.charAt(0)-'A'][cur.charAt(1)-'A'][cur.charAt(2)-'A']=true;
        }
        function(bottom,"",exist,0);
        return result;
        // write your code here
    }

    private void function(String pre, String cur,boolean[][][] exist,int length) {
        if(result)
            return;
        if(pre.length()==1){
            result=true;
            return;
        }
        int first=(pre.charAt(length)-'A'),second=pre.charAt(length+1)-'A';
        for(int i=0;i<26;i++){
            if(exist[first][second][i]){
                String curr=cur+(char)(i+'A');
                if(length==pre.length()-2){
                    function(curr,"",exist,0);
                }else {
                    function(pre,curr,exist,length+1);
                }
            }
        }
    }

}
