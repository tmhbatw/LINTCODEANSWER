package LINTCODE13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE1274 {
    /*Description
    给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
    定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
    找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
    * */


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[] index=new int[nums1.length];
        int[] sum=new int[nums1.length];
        for(int i=0;i<sum.length;i++){
            sum[i]=nums1[i]+nums2[0];
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int j=0;j<k;j++){
            int min=sum[0];
            int curindex=0;
            for(int i=1;i<sum.length;i++){
                if(sum[i]<min){
                    min=sum[i];
                    curindex=i;
                }
            }
            if(min==Integer.MAX_VALUE)
                return res;
            List<Integer> cur=new ArrayList<>();
            cur.add(nums1[curindex]);
            cur.add(nums2[index[curindex]]);
            res.add(cur);
            index[curindex]++;
            sum[curindex]=index[curindex]==nums2.length?Integer.MAX_VALUE:nums1[curindex]+nums2[index[curindex]];
        }
        return res;
        // write your code here
    }
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
    }


    /*Solution
    * 可以使用小根堆
    * */

    //小根堆实现
/*    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0]+o2[1]==o1[0]+o1[1])
                    return o2[0]-o1[0];
                return o2[0]+o2[1]-o1[0]-o1[1];
            }
        });
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                queue.add(new int[]{nums1[i],nums2[j]});
                if(queue.size()>k)
                    queue.poll();
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            List<Integer> list=new ArrayList<>();
            list.add(cur[0]);
            list.add(cur[1]);
            res.add(0,list);
        }
        return res;
        // write your code here
    }*/


}
