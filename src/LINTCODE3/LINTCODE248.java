package LINTCODE3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE248 {
    /*Description
    * 给定一个整数数组 （下标由 0 到 n-1，其中 n 表示数组的规模，数值范围由 0 到 10000），以及一个 查询列表。对于每一个查询，将会给你一个整数，请你返回该数组中小于给定整数的元素的数量。
    * Challenge
    * 可否用一下三种方法完成以上题目。
    * 仅用循环方法
    * 分类搜索 和 二进制搜索
    * 构建 线段树 和 搜索
    * */

    /*Solution
    *二进制查找可能需要优先排序
    * 所有方法全部涉及到过
    * 二分法与线段树复杂度应该均为O(logN)
    * */

    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        List<Integer> result=new ArrayList<>();
        Arrays.sort(A);
        for(int i=0;i<queries.length;i++){
            int target=queries[i];
            int m=0,n=A.length-1;
            while(m<n){
                int mid=m+(n-m)/2;
                if(A[mid]<target){
                    m=mid+1;
                }else
                    n=mid;
            }
            result.add(m);
        }
        return result;
        // write your code here
    }
}
