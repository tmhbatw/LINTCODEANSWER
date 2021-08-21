package LINTCODE10;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE984 {
    /*Description
    *如果一个数字序列由至少三个元素组成, 并且任何两个相邻元素之间的差值相同, 则称之为等差数列.`
    * */

    public int numberOfArithmeticSlices(int[] A) {
        int length=A.length;
        Map<Long,Long>[] map=new Map[length];
        long result=0;
        Long[] a=new Long[length];
        for(int i=0;i<length;i++) {
            a[i]= (long) A[i];
            map[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                map[i].put(a[i]-a[j], map[i].getOrDefault(a[i]-a[j],0L)+1L+map[j].getOrDefault(a[i]-a[j],0L));
            }
            for(Map.Entry<Long,Long> entry:map[i].entrySet())
                result+=entry.getValue();
        }
        for(Map<Long,Long> cur:map){
            System.out.println(cur);
        }
        result-=((long) length *(length-1))/2;
        return (int)result;
        // Write your code here
    }

    public static void main(String[] args){
        int[] num=new int[]{2,2,3,4};
        System.out.println(new LINTCODE984().numberOfArithmeticSlices(num));
    }


}
