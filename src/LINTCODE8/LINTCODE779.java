package LINTCODE8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE779 {
    /*Description
    * 请完成一个能够给出word 的所有“缩写”的函数（给出任意一种排列即可）
    * */

    public List<String> generateAbbreviations(String word) {
        if(word.length()==0)
            return Collections.emptyList();
        List<String> result=new ArrayList<>();
        recursion(result,"",word,true);
        return result;
        // Write your code here
    }

    private void recursion(List<String> result,String res,String word,boolean canBeNumber){
        if(word.length()==0) {
            result.add(res);
            return;
        }
        recursion(result,res+word.charAt(0),word.substring(1),true);
        if(canBeNumber){
            for(int i=0;i<word.length();i++){
                recursion(result,res+""+(i+1),word.substring(i+1),false);
            }
        }
    }
}
