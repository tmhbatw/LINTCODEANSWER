package LINTCODE;

import datastructure.NestedInteger;

import java.util.*;

public class LINTCODE22 {
    /*Description
    * Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
    * */

    /*Solution
    * 此题新意在于自己创建了一个数据结构要求使用，看懂即不难解决
    * 递归算法时间复杂度为O(n)
    * challenge:
    * 用非递归的方式解答
    * 遍历一个nestedList列表，当为数字时输入结果集中，当不是则将列表放入所遍历的列表中
    * */

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<nestedList.size();i++){
            if(nestedList.get(i).isInteger())
                res.add(nestedList.get(i).getInteger());
            else{
                nestedList.addAll(i+1,nestedList.get(i).getList());
            }
        }
        return res;
    }

}
