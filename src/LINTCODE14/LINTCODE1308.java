package LINTCODE14;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1308 {
    /*Description
    *数字可以被视为其因数的乘积。 例如，
    * 8 = 2 x 2 x 2;
    * = 2 x 4。
    * 编写一个函数，可以输入整数n并返回其因子的所有可能组合。
    * */

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                List<Integer> res=new ArrayList<>();
                res.add(i);
                function(result,res,i,n/i);
            }
        }
        return result;
        // write your code here
    }

    private void function(List<List<Integer>> result,List<Integer> res,int start,int n){
        List<Integer> cur=new ArrayList<>(res);
        cur.add(n);
        result.add(cur);
        for(int i=start;i<=Math.sqrt(n);i++){
            if(n%i==0) {
                List<Integer> list = new ArrayList<>(res);
                list.add(i);
                function(result, list, i, n / i);
            }
        }
    }
}
