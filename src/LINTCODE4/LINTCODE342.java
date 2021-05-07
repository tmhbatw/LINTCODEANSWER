package LINTCODE4;

import java.util.*;

public class LINTCODE342 {
    /*Description
    * 给你一个长度为n的序列，在他的子序列中让你找一个山谷序列，山谷序列定义为：
    * 序列的长度为偶数。假设子序列的长度为2n。则前n个数是严格递减的，后n个数是严格递增的，
    * 并且第一段的最后一个元素和第二段的第一个元素相同，也是这段序列中的最小值。
    * 现在想让你找所有子序列中满足山谷序列规则的最长的长度为多少？
    * */



    public int valley(int[] num) {
        int length=num.length;
        int[] left=new int[length];
        List<Integer> list=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<length;i++){
            int cur=num[i];
            function(left,list,cur,i);
            if(!map.containsKey(cur)){
                map.put(cur,new ArrayList<>());
            }
            List<Integer> curList=map.get(cur);
            curList.add(i);
        }
        int[] right=new int[length];
        list=new ArrayList<>();
        for(int i=length-1;i>=0;i--){
            int cur=num[i];
            function(right,list,cur,i);
        }
        int result=0;
        for(Map.Entry entry : map.entrySet()){
            List<Integer> l= (List<Integer>) entry.getValue();
            for(int i=0;i<l.size()-1;i++){
                result=Math.max(result,Math.min(left[l.get(i)],right[l.get(i+1)])*2);
            }
        }
        return result;
        // write your code here
    }

    private void function(int[] left,List<Integer> list,int cur,int i){
        if(list.isEmpty()||list.get(list.size()-1)>cur){
            list.add(cur);
            left[i]=list.size();
        }else{
            int l=0,r=list.size();
            while(l<=r){
                int mid = (l+r)/2;
                if(list.get(mid)<=cur&&(mid==0||list.get(mid-1)>cur)){
                    list.set(mid,cur);
                    left[i]=mid+1;
                    break;
                }else if(list.get(mid)>cur){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
    }
}
