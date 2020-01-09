package LINTCODE10;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE914 {
    /*Description
    * 翻转游戏
    * */

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result=new ArrayList<>();
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)&&s.charAt(i)=='+'){
                String cur=s.substring(0,i)+"--"+s.substring(i+2);
                result.add(cur);
            }
        }
        return result;
        // write your code here
    }
}
