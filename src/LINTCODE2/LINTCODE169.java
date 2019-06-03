package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE169 {
    public List<String> towerOfHanoi(int n) {
        /*Description
        * 汉诺塔问题
        * */

        /*Solution
        * 简单的递归即可解决
        * */
        return recursion(n,"A","C","B");
        // write your code here
    }

    private List<String> recursion(int n,String from,String to,String mid){
        List<String> result=new ArrayList<>();
        if(n==1){
            String res="from "+from+" to "+to;
            result.add(res);
        }else{
            result.addAll(recursion(n-1,from,mid,to));
            result.addAll(recursion(1,from,to,mid));
            result.addAll(recursion(n-1,mid,to,from));
        }
        return result;
    }

}
