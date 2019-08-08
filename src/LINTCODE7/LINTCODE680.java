package LINTCODE7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE680 {
    /*Description
    * 分割字符串
    * 给一个字符串,你可以选择在一个字符或两个相邻字符之后拆分字符串,使字符串由仅一个字符或两个字符组成,输出所有可能的结果
    * */

    public static List<List<String>> splitString(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> res=new ArrayList<>();
        recursion(result,res,s);
        return result;
        // write your code here
    }

    private static void recursion(List<List<String>> result,List<String> res,String s){
        if(s.length()==0){
            result.add(res);
            System.out.println(res);
            return ;
        }
        for(int i=0;i<2&&i<s.length();i++){
            List<String> cur=new ArrayList<>(res);
            cur.add(s.substring(0,i+1));
            recursion(result,cur,s.substring(i+1));
        }
    }

    public static void main(String[] args){
        splitString("123");
    }
}
