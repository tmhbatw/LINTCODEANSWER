package LINTCODE13;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1267 {
    /*Description
    * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
    * */

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=9;i++){
            recursion(result,n,i);
        }
        return result;
        // write your code here
    }

    private void recursion(List<Integer> result, int n, int pre){
        if(pre>n)
            return;
        result.add(pre);
        for(int i=0;i<=9;i++){
            recursion(result,n,pre*10+i);
        }
    }
}
