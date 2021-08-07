package LINTCODE11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1048 {
    /*Description
    * 整数区间[a，b]（整数a <b）是从a到b的所有连续整数的集合，包括a和b。
    * 求一个集合S的最小值，使得对于区间中的每一个整数区间A，S与A的交集的大小至少为2。
    * */

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            return o1[1]-o2[1];
        });
        int count1=-1;
        int count2=-1;
        int count = 0;
        for(int[] cur:intervals){
            if(count2<cur[0]){
                count1=cur[1]-1;
                count2=cur[1];
                count+=2;
            }else if(count1<cur[0]){
                count1=count2;
                count2=cur[1];
                count+=1;
            }
        }
        return count;
        // write your code here
    }
}
