package LINTCODE9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE896 {
    /*Description
    * 给定一个无重复的质数数组arr，每个质数最多使用一次，求所有无重复的乘积并从小到大排序。
    * */

    public int[] getPrimeProduct(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            recursion(set,i+1,arr[i],arr);
        }
        int[] result=new int[set.size()];
        int index=0;
        for(int num:set)
            result[index++]=num;
        Arrays.sort(result);
        return result;
        // Write your code here
    }

    private void recursion(Set<Integer> set,int start ,int curRes,int[] arr){
        if(start==arr.length)
            return;
        set.add(curRes*arr[start]);
        recursion(set,start+1,curRes*arr[start],arr);
        recursion(set,start+1,curRes,arr);
    }
}
