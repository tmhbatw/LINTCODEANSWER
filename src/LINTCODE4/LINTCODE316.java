package LINTCODE4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE316 {
    /*Description
    * 给一个数组，给出所有可能的排列组合出的数小于给定的数字
    * */

    public List<Integer> combinationSet(List<Integer> num, int target) {
        List<Integer> result=new ArrayList<>();
        Collections.sort(num);
        if(num.get(0)==0)
            result.add(0);
        else
            recursion(result,num.get(0),target,num);
        for(int i=1;i<num.size();i++){
            recursion(result,num.get(i),target,num);
        }
        return result;
        // write your code here
    }

    private void recursion(List<Integer> result,int pre, int target, List<Integer> num){
        if(pre>=target)
            return;
        result.add(pre);
        for(int cur:num){
            recursion(result,pre*10+cur,target,num);
        }
    }
}
