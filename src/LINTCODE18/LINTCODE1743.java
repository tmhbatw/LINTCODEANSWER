package LINTCODE18;

import java.util.HashSet;

public class LINTCODE1743 {
    /*Description
    * 我们有一个非负整数数组 A。
    * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），
    * 我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
    * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
    * */

    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> result=new HashSet<>();
        HashSet<Integer> pre=new HashSet<>();
        for(int cur:A){
            HashSet<Integer> curSet=new HashSet<>();
            curSet.add(cur);
            for(int num:pre)
                curSet.add(num|cur);
            result.addAll(curSet);
            pre=curSet;
        }
        return result.size();
        // write your code here
    }
}
