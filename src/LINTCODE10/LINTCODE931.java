package LINTCODE10;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE931 {
    /*Description
    * 有 k 个有序数组 nums。找到这 k 个有序数组的中位数。
    * */

    public double findMedian(int[][] nums) {
        if(nums==null||nums.length==0)
            return 0;
        nums = removeInvalid(nums);
        int count =0;
        for(int[] cur:nums){
            count+=cur.length;
        }
        if(count==0)
            return 0;
        int midCount = (count+1)/2;
        if(count%2==1){
            return getMidNumber(nums,midCount);
        }
        int num1=getMidNumber(nums,midCount);
        int num2=getMidNumber(nums,midCount+1);
        return num1+1.0*(num2-num1)/2;
        // write your code here
    }

    private int getMidNumber(int[][] nums, int midCount){
        int max=Integer.MIN_VALUE;
        for(int[] cur:nums){
            for(int curr:cur)
                max=Math.max(curr,max);
        }
        int l=0,r=max;
        while(l<r){
            int mid=l+(r-l)/2;
            int curCount = 0;
            for(int[] cur:nums)
                curCount+=getCount(cur,mid);
            if(curCount<midCount)
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }

    private int[][] removeInvalid(int[][] nums){
        List<int[]> list=new ArrayList<>();
        for(int[] cur:nums){
            if(cur!=null&&cur.length!=0)
                list.add(cur);
        }
        int[][] num=new int[list.size()][];
        for(int i=0;i<list.size();i++)
            num[i]=list.get(i);
        return num;
    }

    private int getCount(int[] cur,int num){
        if(cur[0]>num)
            return 0;
        int l=0,r=cur.length-1;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(cur[mid]<=num){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return l+1;
    }
}
