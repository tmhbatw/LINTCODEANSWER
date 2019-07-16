package LINTCODE6;

import java.util.*;

public class LINTCODE547 {
    /*Description
    * 给出两个数组，写出一个方法求出它们的交集
    * */

    /*Solution
    * 将一个数组保存在set数组中，判断另一个数组中的数字是否在set中
    * */

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for(int num:nums1)
            set1.add(num);
        List<Integer> result=new ArrayList<>();
        Set<Integer> set2=new HashSet<>();
        for(int num:nums2)
            set2.add(num);
        Iterator ii=set2.iterator();
        while(ii.hasNext()){
            int cur= (int) ii.next();
            if(set1.contains(cur))
                result.add(cur);
        }
        int[] res=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
        // write your code here
    }


}
