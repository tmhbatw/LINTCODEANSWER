package LINTCODE10;

import datastructure.NestedInteger;

import java.util.*;

public class LINTCODE905 {
    /*Description
    * 给一个嵌套的整数列表, 返回列表中所有整数由它们的深度加权后的总和.
    * 每一个元素可能是一个整数或一个列表(其元素也可能是整数或列表)。
    * 注意，在之前的题目嵌套列表的加权和中，从根结点到叶子结点，深度权重是递增的。
    * 在嵌套列表的加权和II中，深度权重的定义是自下而上的，也就是说，最底层叶子结点的深度权重是1 ，根结点的深度权重最大。
    * */

    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> stack=new LinkedList<>();
        stack.addAll(nestedList);
        List<Integer> list=new ArrayList<>();
        while(!stack.isEmpty()){
            int size=stack.size();
            int curSum=0;
            for(int i=0;i<size;i++){
                NestedInteger cur=stack.poll();
                if(cur.isInteger())
                    curSum+=cur.getInteger();
                else
                    stack.addAll(cur.getList());
            }
            list.add(curSum);
        }
        int size=list.size();
        int result=0;
        for(int i=0;i<size;i++)
            result+=(size-i)*list.get(i);
        return result;
        // Write your code here.
    }
}
