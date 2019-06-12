package LINTCODE5;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE427 {
    /*Description
    * Given n, and there are n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    * */

    /*Solution
    * 递归回溯处理即可
    * */

    public List<String> generateParenthesis(int n) {
        List<String> s=new ArrayList<>();
        recursion(s,"",n,0);
        return s;
        // write your code here
    }

    private void recursion(List<String> result,String res,int n,int nn){
        if(n==0&&nn==0){
            result.add(res);
            return;
        }
        if(nn==0){
            recursion(result,res+"(",n-1,1);
        }
        if(n==0){
            recursion(result,res+")",n,nn-1);
        }
        recursion(result,res+"(",n-1,nn+1);
        recursion(result,res+")",n,nn-1);

    }
}
