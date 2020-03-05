package LINTCODE14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1321 {
    /*Description
    * 找到所有可能的k个数字组合，它们加起来为n，假设只能使用1到9的数字，并且每个组合应该是一组唯一的数字。
    * */

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k==0)
            return Collections.emptyList();
        List<List<Integer>> result=new ArrayList<>();
        recursion(result,new ArrayList<>(),1,k,n);
        return result;
        // write your code here
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int start,int left,int n){
        if(left==1){
            if(n<=9&&n>=start) {
                res.add(n);
                result.add(res);
            }
            return;
        }
        for(int i=start;i<9;i++){
            if(n<=i)
                return;
            List<Integer> curRes=new ArrayList<>(res);
            curRes.add(i);
            recursion(result,curRes,i+1,left-1,n-i);
        }
    }
}
