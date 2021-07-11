package LINTCODE12;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LINTCODE1117 {
    /*Description
    * 有k个升序排列的数组，寻找一个最小范围，使每个数组中至少有一个元素被包含。
    * */

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> q=new PriorityQueue<>(((o1, o2) -> o1[0]-o2[0]));
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            List<Integer> list=nums.get(i);
            if(list.isEmpty())
                return new int[2];
            q.add(new int[]{list.get(0),i,0});
            start=Math.min(start,list.get(0));
            end=Math.max(end,list.get(0));
        }
        int[] res=new int[]{start,end};
        int range=end-start;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int i=cur[1],j=cur[2];
            if(nums.get(i).size()==j+1)
                break;
            int[] next=new int[]{nums.get(i).get(j+1),i,j+1};
            end=Math.max(next[0],end);
            q.add(next);
            start=q.peek()[0];
            if(end-start<range){
                range=end-start;
                res[0]=start;
                res[1]=end;
            }
        }
        return res;
        // write your code here
    }
}
