package LINTCODE9;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE813 {
    /*Description
    * 给出了两个A和B的列表，从A映射到B，B是由A的一种回文构词法构成通过随机化A中元素的顺序来实现的。
    * 我们想要找到一个指数映射P，从A到B，映射P[i] = j表示A出现在B中的第i个元素。
    * 这些列表A和B可能包含重复。如果有多个答案，输出任何一个。
    * */

    /*Solution
    * 使用一个HashMap用来保存B数组中key与value之间的对应关系
    * */

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> map=new HashMap<>(B.length);
        for(int i=0;i<B.length;i++){
            if(!map.containsKey(B[i])) {
                map.put(B[i], i);
            }
        }
        int[] result=new int[A.length];
        for(int i=0;i<A.length;i++){
            result[i]=map.get(A[i]);
        }
        return result;
        // Write your code here
    }



}
