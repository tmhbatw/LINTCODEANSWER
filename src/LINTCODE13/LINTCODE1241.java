package LINTCODE13;

import datastructure.Interval;

import java.util.*;

public class LINTCODE1241 {
    /*Description
    * 给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
    * 对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。
    * 如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
    * */

    class Point{
        int left;
        int right;
        int index;
        public Point(int left,int right,int index){
            this.left=left;
            this.right=right;
            this.index=index;
        }
    }
    public List<Integer> findRightInterval(List<Interval> intervals) {
        List<Point> list=new ArrayList<>();
        for(int i=0;i<intervals.size();i++){
            list.add(new Point(intervals.get(i).start,intervals.get(i).end,i));
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.left));
        int size=intervals.size();
        Integer[] res=new Integer[size];
        Arrays.fill(res, -1);
        for(int i=0;i<size;i++){
            Point cur=list.get(i);
            int target=cur.right;
            int left=i+1,right=size-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(target<=list.get(mid).left&&target>list.get(mid-1).left){
                    res[cur.index]=list.get(mid).index;
                    break;
                }else if(target>list.get(mid).left){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return Arrays.asList(res.clone());
        // write your code here
    }
}
