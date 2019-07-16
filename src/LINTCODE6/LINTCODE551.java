package LINTCODE6;

import datastructure.NestedInteger;

import java.util.List;

public class LINTCODE551 {
    /*Description
    *给一个嵌套的整数列表, 返回列表中所有整数由它们的深度加权后的总和. 每一个元素可能是一个整数或一个列表
    * (其元素也可能是整数或列表)
    * */

    private int result=0;

    public int depthSum(List<NestedInteger> nestedList) {
        for(NestedInteger cur:nestedList){
            getDepth(cur,1);
        }
        return result;
        // Write your code here
    }

    private void getDepth(NestedInteger cur,int count){
        if(cur.isInteger()){
            result+=cur.getInteger()*count;
        }
        List<NestedInteger> list=cur.getList();
        count=count+1;
        for(NestedInteger curr:list){
            getDepth(curr,count);
        }
    }
}
