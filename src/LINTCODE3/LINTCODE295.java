package LINTCODE3;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE295 {
    /*Description
    *给定两个排序后的区间序列，序列内每个区间两两互不相交，返回两个序列相交的区间的下标
    * */

    public List<List<Integer>> Intersection(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> result=new ArrayList<>();
        int startIndex=0;
        int length=b.size();
        for(int i=0;i<a.size();i++){
            List<Integer> cur=a.get(i);
            int start=cur.get(0),end=cur.get(1);
            while(startIndex<length&&start>b.get(startIndex).get(1))
                startIndex++;
            if(startIndex==length)
                return result;
            while(startIndex<length&&b.get(startIndex).get(0)<=end){
                List<Integer> res=new ArrayList<>();
                res.add(i);
                res.add(startIndex++);
                result.add(res);
            }
            if(startIndex>0)
                startIndex--;
        }
        return result;
        // write your code here
    }

}
