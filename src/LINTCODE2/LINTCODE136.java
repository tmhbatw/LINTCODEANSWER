package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE136 {
    /*Description
    *Given a string s. Partition s such that every substring in the partition is a palindrome.
    * Return all possible palindrome partitioning of s.
    * */

    /*Solution
    *典型的递归回溯问题
    * */

    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> res=new ArrayList<>();
        recursion(result,res,s);
        return result;
        // write your code here
    }

    private void recursion(List<List<String>> result,List<String> res,String s){
        if(s.length()==0){
            result.add(res);
            return;
        }
        for(int i=0;i<s.length();i++){
            String curr=s.substring(0,i+1);
            if(!palinedrome(curr))
                continue;
            List<String> ress=new ArrayList<>();
            ress.addAll((res));
            ress.add(curr);
            recursion(result,ress,s.substring(i+1,s.length()));
        }
    }

    private boolean palinedrome(String curr){

        return new StringBuffer(curr).reverse().toString().equals(curr);
    }
}
