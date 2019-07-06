package LINTCODE3;

import java.util.*;

public class LINTCODE243 {

    /*Description
    * 一对整数是相亲数是说他们各自的所有有效因子（除了自己以外的因子）之和等于另外一个数。比如 (220, 284) 就是一对相亲数。因为：
    * */

    /*Solution
    * 计算每一个数的有效因子之和，遍历循环
    * 注意小的数要在前面
    * */

    public List<List<Integer>> amicablePair(int k) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=k;i>=2;i--){
            int val=getAmicableVal(i);
            if(val>=i)
                continue;
            if(getAmicableVal(val)==i){
                List<Integer> res=new ArrayList<>();
                res.add(val);
                res.add(i);
                result.add(res);
            }
        }
        return result;
        // write your code here
    }

    public int getAmicableVal(int cur){
        int result=0,i;
        for(i=2;i*i<cur;i++){
            if(cur%i==0){
                result+=i;
                result+=cur/i;
            }
        }
        if(i*i==cur){
            result+=i;
        }
        return result+1;
    }
}
