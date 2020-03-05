package LINTCODE19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1831 {
    /*Description
    * 给定两个整数数组A和B。
    * 数组B中存在任意一个数字等于数组A中两个不同索引的数字相加之和，那么返回True, 否则返回False。
    * */

    public boolean ArraySummarization(int[] A, int[] B) {
        Set<Integer> set=new HashSet<>();
        for(int num:B)
            set.add(num);
        for(int i=0;i<A.length;i++){
            int cur=A[i];
            for(int j=i+1;j<A.length;j++){
                if(set.contains(cur+A[j]))
                    return true;
            }
        }
        return false;
        // write your code here
    }
}
