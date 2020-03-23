package LINTCODE15;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE1409 {
    /*Description
    * 给出一个矩阵mat，找出所有行都出现的数字，如果有多个，就输出最小的那个数。如果没有，输出-1。
    * */

    public int findingNumber(int[][] mat) {
        if(mat==null||mat.length==0)
            return -1;
        Set<Integer> set=new HashSet<>();
        for(int num:mat[0])
            set.add(num);
        for(int[] cur:mat){
            Set<Integer> curSet=new HashSet<>();
            for(int num:cur){
                if(set.contains(num))
                    curSet.add(num);
            }
            if(curSet.size()==0)
                return -1;
            set=null;
            set=curSet;
        }
        int result=Integer.MAX_VALUE;
        for(int num:set)
            result=Math.min(result,num);
        return result;
        // Write your code here
    }
}
