package LINTCODE18;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1710 {
    /*Description
    * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
    * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
    * 那么数组 A 是漂亮数组。
    * 给定 N，返回任意漂亮数组 A（保证存在一个）。
    * */

    public int[] beautifulArray(int N) {
        List<Integer> res=recursion(N);
        int[] result=new int[N];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
        // write your code here.
    }

    private List<Integer> recursion(int n){
        List<Integer> result=new ArrayList<>();
        result.add(1);
        if(n==1)
            return result;
        result.add(2);
        if(n==2)
            return result;
        if(n%2==0){
            List<Integer> res=new ArrayList<>();
            List<Integer> list=recursion(n/2);
            for(int i=0;i<list.size();i++){
                res.add(list.get(i)*2-1);
            }
            for(int i=0;i<list.size();i++){
                res.add(list.get(i)*2);
            }
            return res;
        }
        List<Integer> res=new ArrayList<>();
        List<Integer> list1=recursion(n/2+1);
        List<Integer> list2=recursion(n/2);
        for(int i=0;i<list1.size();i++)
            res.add(list1.get(i)*2-1);
        for(int i=0;i<list2.size();i++)
            res.add(list2.get(i)*2);
        return res;
    }
}
