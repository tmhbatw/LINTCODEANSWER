package LINTCODE19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1833 {
    /*Description
    * 给你一个数组boxes和一个整数target。第i个盒子中有boxes[i]根钢笔。如果sum(boxes[i] + boxes[i+1] + ... + boxes[j]) == target，
    * 那么区间[i,j]被成为有效区间。请你找出两个不重叠的有效区间，并且使这两个区间长度之和最小，将最小长度返回。如果没有这样的两个有效区间，返回-1。
    * boxes的长度<=10的6次方且boxes[i] > 0
    * */

    public int minimumBoxes(int[] boxes, int target) {
        List<int[]> list=new ArrayList<>();
        int length=boxes.length;
        int last=0;
        int sum=0;
        while(last<length&&sum+boxes[last]<target){
            sum+=boxes[last++];
        }
        for(int i=0;i<boxes.length;i++){
            while(last<length&&sum+boxes[last]<target)
                sum+=boxes[last++];
            if(last<length&&sum+boxes[last]==target){
                list.add(new int[]{i,last});
                sum+=boxes[last++];
            }
            sum-=boxes[i];
        }
        for(int[] cur:list)
            System.out.println(Arrays.toString(cur));
        int result=-1;
        for(int i=0;i<list.size();i++){
            int[] cur1=list.get(i);
            for(int j=list.size()-1;j>i;j--){
                int[] cur2=list.get(j);
                if(cur1[1]<cur2[0]){
                    if(result==-1){
                        result=getRes(cur1,cur2);
                    }else
                        result=Math.min(result,getRes(cur1,cur2));
                }else
                    break;
            }
        }
        return result;
        // write your code here
    }

    private int getRes(int[] cur1,int[] cur2) {
        return cur1[1]-cur1[0]+1+cur2[1]-cur2[0]+1;
    }
}
