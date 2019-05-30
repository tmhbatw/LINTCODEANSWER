package LINTCODE1;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE10 {

    /*Description
    * 给出一个字符串，找到它的所有排列，注意同一个字符串不要打印两次。
    * */

    /*Solution
    * 解题思路：递归回溯算法，并注意去重复
    * （PS：递归回溯算法适用于大部分题型）
    * */

    public List<String> permutationString(String str){
        List<String> result=new ArrayList<>();
        String res="";
        recursion(result,str,res,str.length());
        removeList(result);
        return result;
    }

    //递归方法
    private void recursion(List<String> result,String str,String res,int n){
        if(res.length()==n){
            result.add(res);
            return;
        }
        for(int i=0;i<str.length();i++){
            recursion(result,removeChar(str,i),res+str.charAt(i),n);
        }

    }
    private String removeChar(String str,int i){
        return str.substring(0,i)+str.substring(i+1,str.length());
    }

    //去重方法
    private void removeList(List<String> result){
        for(int i=0;i<result.size();i++){
            String curr=result.get(i);
            for(int j=result.size()-1;j>i;j--){
                if(curr.equals(result.get(j))){
                    result.remove(j);
                }
            }
        }
    }
}
