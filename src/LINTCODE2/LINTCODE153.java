package LINTCODE2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE153 {
    /*Description
    * 给定一个数组 num 和一个整数 target. 找到 num 中所有的数字之和为 target 的组合.
    * */

    /*Solution
    * 与上一题思路基本相同
    * */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        recursion(result,res,num,target,0);
        delete(result);
        return result;
        // write your code here
    }

    private void recursion(List<List<Integer>> result,List<Integer> res,int[] num,int target,int start){
        if(target==0){
            result.add(res);
            return;
        }
        for(int i=start;i<num.length;i++){
            if(target<num[i])
                return;
            List<Integer> ress=new ArrayList<>();
            ress.addAll(res);
            ress.add(num[i]);
            recursion(result,res,num,target-num[i],i+1);
        }

    }

    private void delete(List<List<Integer>> result){
        for(int i=0;i<result.size();i++){
            List<Integer> list=result.get(i);
            for(int j=result.size()-1;j>i;j--){
                if(result.get(j).equals(list))
                    result.remove(j);
            }
        }
    }
}
