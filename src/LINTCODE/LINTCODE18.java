package LINTCODE;

import java.util.List;

public class LINTCODE18 {
    /*Description
    *Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
    *Each element in a subset must be in non-descending order.
    * The ordering between two subsets is free.
    * The solution set must not contain duplicate subsets.
    * */

    /*Solution
    * 与17题解题思路基本一致，增加一部去重复的方法，去重复方法如下
    * */

    private void removeResult(List<List<Integer>> result){
        for(int i=0;i<result.size();i++){
            List<Integer> res=result.get(i);
            for(int j=result.size()-1;j>i;j--){
                if(res.equals(result.get(j)))
                    res.remove(j);
            }
        }
    }

}
