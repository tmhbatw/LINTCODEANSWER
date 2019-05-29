package LINTCODE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE90 {
    /*Description
    * Given n unique postive integers, number k (1<=k<=n) and target.
    * Find all possible k integers where their sum is target.
    * */

    /*Solution
    *递归会说，将结果保存在result中，
    *递归所有可能的数列情况，计算其数值，如果与target相等且个数与k相等则将结果保存在result中
    * */

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        recursion(result,res,A,k,target,0);
        return result;
        // write your code here
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int[] A,int k,int target,int start){
        if(target==0&&k==0){
            result.add(res);
            return;
        }
        if(target==0&&k!=0||k==0)
            return ;
        for(int i=start;i<A.length-k+1;i++){

            if(target<A[i])
                continue;
            List<Integer> curr= new ArrayList<>();
            curr.addAll(res);
            curr.add(A[i]);
            recursion(result,curr,A,k-1,target-A[i],i+1);
        }

    }
}
