package LINTCODE17;

import java.util.HashMap;

public class LINTCODE1604 {
    /*Description
    * 给定一个由N个整数组成的数组A，返回两个数字的最大总和，规定这两个数的所有位加起来相等。
    * 如果没有两个数字的各个位相加和相等，则该函数应返回-1。
    * */

    public int MaximumSum(int[] A) {
        int result=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int cur:A){
            int sum=getSum(cur);
            if(map.containsKey(sum)) {
                result = Math.max(result, map.get(sum) + cur);
                map.put(sum,Math.max(map.get(sum),cur));
            }else
                map.put(sum,cur);
        }
        return result;
        // write your code here
    }

    private int getSum(int cur){
        int result=0;
        while(cur>0){
            result+=cur%10;
            cur/=10;
        }
        return result;
    }
}
