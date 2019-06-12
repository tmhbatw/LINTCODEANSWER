package LINTCODE5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE425 {

    /*Description
    * Given a digit string excluded '0' and '1', return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
    * */

    /*Solution
    * 递归遍历
    * */
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return Collections.emptyList();
        List<String> result=new ArrayList<>();
        recursion(result,"",digits);
        return result;
        // write your code here
    }

    private void recursion(List<String> result,String res,String digits){
        if(digits.equals("")){
            result.add(res);
            return;
        }
        String[] curr=getString(digits.charAt(0));
        for(int i=0;i<curr.length;i++){
            recursion(result,res+curr[i],digits.substring(1,digits.length()));
        }

    }

    private String[] getString(char cur){
        switch (cur){
            case '2':return new String[]{"a","b","c"};
            case '3':return new String[]{"d","e","f"};
            case '4':return new String[]{"g","h","i"};
            case '5':return new String[]{"j","k","l"};
            case '6':return new String[]{"m","n","o"};
            case '7':return new String[]{"p","q","r","s"};
            case '8':return new String[]{"t","u","v"};
            case '9':return new String[]{"w","x","y","z"};
        }
        return new String[]{""};
    }
}
