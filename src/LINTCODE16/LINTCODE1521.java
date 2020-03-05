package LINTCODE16;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1521 {
    /*Description
    *Twitter需要用户ID唯一，并且在将用户ID分配给其客户时，Twitter希望用户ID的总和最小。
    * 给定n个用户的随机用户ID数组，请递增所有重复元素（在原来的元素上递增），直到所有用户ID都是唯一的并确保其总和最小。
    * */

    public int UniqueIDSum(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int num:arr){
            while(set.contains(num))
                num++;
            set.add(num);
        }
        int result=0;
        for(int cur:set)
            result+=cur;
        return result;
        // write your code here
    }
}
