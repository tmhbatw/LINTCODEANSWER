package LINTCODE2;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE152 {
    /*Description
    *给定两个整数 n 和 k. 返回从 1, 2, ... , n 中选出 k 个数的所有可能的组合.
    * */
    /*Solution
    *简单的动态规划
    * */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        recursion(result,res,n,k,0);
        return result;
        // write your code here
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int n,int k,int start){
        for(int i=start;i<n-k+1;i++){
            List<Integer> ress=new ArrayList<>();
            ress.addAll(res);
            ress.add(i+1);
            if(k-1==0){
                result.add(ress);
                return;
            }
            recursion(result,ress,n,k-1,i+1);
        }
    }
}
