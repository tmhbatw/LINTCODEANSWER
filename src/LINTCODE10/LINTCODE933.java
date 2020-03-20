package LINTCODE10;

import java.util.Arrays;

public class LINTCODE933 {
    /*Description
    * 给出一个字符串tuple,表示一系列数组如: "(1,2,3),(4,5,6),(7,8,9)"，接下来是一个数n,
    * 表示要求每个数组第n个元素的乘积。
    * */

    public long tupleMultiply(String tuple, int n) {
        tuple=tuple.substring(1,tuple.length()-1);
        String[] s=tuple.split("\\),\\(");
        long result=1;
        n--;
        for(String cur:s){
            String[] ss=cur.split(",");
            result*=Integer.parseInt(ss[n]);
        }
        return result;
        // Write your code here
    }
}
