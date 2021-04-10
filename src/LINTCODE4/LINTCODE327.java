package LINTCODE4;

import java.util.*;

public class LINTCODE327 {
    /*Description
    * 对于给定数组中的每个元素，计算值与它相同的所有其他元素的距离和，即索引差的绝对值之和，
    * 在数组中返回结果值。例如，如果数组中下标2和3的元素相等，则元素2的距离和为| 2 - 3 | =1，3号元素的距离和为| 3 - 2 | =1。
    * */

    public List<Long> getDistanceMetrics(int[] a) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(!map.containsKey(a[i]))
                map.put(a[i],new ArrayList<>());
            List<Integer> list=map.get(a[i]);
            list.add(i);
        }
        Long[] result=new Long[a.length];
        for(Map.Entry entry:map.entrySet()){
            int key=(int)entry.getKey();
            List<Integer> list= (List<Integer>) entry.getValue();
            long pre=0;
            int preIndex=list.get(0);
            for(int i=1;i<list.size();i++)
                pre+=list.get(i)-list.get(0);
            result[preIndex]=pre;
            int rightCount=list.size()-2;
            int leftCount=0;
            for(int i=1;i<list.size();i++){
                int preDistance=list.get(i)-preIndex;
                pre+= (long) preDistance *(leftCount-rightCount);
                result[list.get(i)]=pre;
                rightCount--;
                leftCount++;
                preIndex=list.get(i);
            }
        }
        return Arrays.asList(result);
        // write your code here.
    }
}
