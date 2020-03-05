package LINTCODE17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE1657 {
    /*Description
    *给出日志文件的操作，输出所有日志文件的最小和最大运行时间差的最大是多少。
    * */

    public int operationTime(int[] op, int[] a) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int i=0;i<op.length;i++){
            Set<Integer> set=map.getOrDefault(op[i],new HashSet<>());
            set.add(a[i]);
            map.put(op[i],set);
        }
        int result=0;
        for(Map.Entry entry:map.entrySet()){
            Set<Integer> set= (Set<Integer>) entry.getValue();
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int num:set){
                min=Math.min(min,num);
                max=Math.max(max,num);
            }
            result=Math.max(result,max-min);
        }
        return result;
        // Write your code here.
    }
}
