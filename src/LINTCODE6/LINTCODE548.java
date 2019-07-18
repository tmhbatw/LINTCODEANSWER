package LINTCODE6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LINTCODE548 {
    /*Description
    *给定两个数组，计算两个数组的交集
    * */

    /*Solution
    * 用一个hashMap保存数组nums1的数据即可
    * */




    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length<nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums1){
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int num:nums2){
            if(!map.containsKey(num)){
                continue;
            }
            int cur=map.get(num);
            if(cur-->=1){
                map.put(num,cur);
                list.add(num);
            }
        }
        int[] result=new int[list.size()];
        int index=0;
        for(int num:list){
            result[index++]=num;
        }
        return result;
       // write your code here
    }
}
