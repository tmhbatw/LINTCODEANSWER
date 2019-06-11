package LINTCODE5;

import datastructure.Interval;

import java.util.ArrayList;

public class LINTCODE400 {

    /*Description
    * 给定一个未经排序的数组, 请找出这个数组排序之后的两个相邻元素之间最大的间距.
    * 如果数组中少于 2 个元素, 返回 0.
    * */

    /*Solution
    * 尝试一下桶排序
    * 注意一下桶的容量与大小，设置桶的容量(max-min)/个数加1，那么一个桶中最大值与最小值的差一定小于我们所求的最大间距
    * 那么我们所求的值一定为两个相邻的桶最小值与最大值之间的差
    * */

    public int maximumGap(int[] nums) {
        if(nums.length<=1)
            return 0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums) {
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int capacity=(max-min)/nums.length+1;
        int num=(max-min)/capacity+1;
        //System.out.println(capacity+"  "+num);
        ArrayList<Bucket> list=new ArrayList<>();
        for(int i=0;i<num;i++){
            list.add(new Bucket());
        }
        for(int n:nums){
            list.get((n-min)/capacity).add(n);
        }
        int result=0;
        int lastMax=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i).max==Integer.MIN_VALUE)
                continue;
            if(lastMax==-1) {
                lastMax =list.get(i).max;
                continue;
            }
            result=Math.max(list.get(i).min-lastMax,result);
            lastMax=list.get(i).max;
        }
        return result;
    }

    class Bucket{
        int min;
        int max;
        public Bucket(){
            this.min=Integer.MAX_VALUE;
            this.max=Integer.MIN_VALUE;
        }
        public void add(int num){
            this.min=Math.min(this.min,num);
            this.max=Math.max(this.max,num);
        }
    }
}
