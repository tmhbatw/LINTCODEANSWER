package LINTCODE7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE652 {
    /*Description
    * 一个非负数可以被视为其因数的乘积。编写一个函数来返回整数 n 的因数所有可能组合。
    * */

    public List<List<Integer>> getFactors(int n) {
        if(isPrime(n))
            return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                List<Integer> cur=new ArrayList<>();
                cur.add(i);
                recursion(result,cur,i,n/i);
            }
        }
        return result;
        // write your code here
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int start,int n){
        List<Integer> cur=new ArrayList<>(res);
        cur.add(n);
        result.add(cur);
        for(int i=start;i<=Math.sqrt(n);i++){
            if(n%i==0){
                List<Integer> curList=new ArrayList<>(res);
                curList.add(i);
                recursion(result,curList,i,n/i);
            }
        }
    }

    private boolean isPrime(int n){
        if(n<=3)
            return false;
        if(n%2==0)
            return true;
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
