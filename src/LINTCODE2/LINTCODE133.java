package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE133 {
    /*Description
    *Given a dictionary, find all of the longest words in the dictionary.
    * Challenge
    * It's easy to solve it in two passes, can you do it in one pass?
    * */

    /*Solution
    *遍历字典并将与最长长度相等的元素输出
    * 当最大长度改变时，清空已有的结果集
    * */

    public List<String> longestWords(String[] dictionary) {
        List<String> result=new ArrayList<>();
        int max=0;
        for(int i=0;i<dictionary.length;i++){
            if(max<dictionary[i].length()){
                result.clear();
            }
            max=Math.max(max,dictionary[i].length());
            if(dictionary[i].length()==max)
                result.add(dictionary[i]);
        }
        return result;
        // write your code here
    }
}
