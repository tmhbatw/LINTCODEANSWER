package LINTCODE7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE605 {
    /*Description
    * 判断是否序列 org 能唯一地由 seqs重构得出. org是一个由从1到n的正整数排列而成的序列，1≤n≤10
    * 重构表示组合成seqs的一个最短的父序列 (意思是，一个最短的序列使得所有 seqs里的序列都是它的子序列).
    * 判断是否有且仅有一个能从 seqs重构出来的序列，并且这个序列是org。
    * */

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if(org.length==1){
            if(seqs.length==0)
                return false;
            for(int[] cur:seqs){
                if(cur.length!=1||cur[0]!=org[0])
                    return false;
            }
            return true;
        }
        int[] num=new int[org.length];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<org.length;i++){
            map.put(org[i],i);
        }

        Map<Integer, List<Integer>> next=new HashMap<>();
        for(int[] cur:seqs){
            if(cur.length==1&&!map.containsKey(cur[0]))
                return false;
            for(int j=1;j<cur.length;j++){
                if(!map.containsKey(cur[0])||!map.containsKey(cur[1]))
                    return false;
                int first=map.get(cur[0]);
                int second=map.get(cur[1]);

                next.putIfAbsent(first,new ArrayList<>());
                next.get(first).add(second);
                num[second]++;
            }
        }

        List<Integer> l=new ArrayList<>();
        int start=-1;
        for(int i=0;i<num.length;i++){
            if(num[i]==0){
                if(start!=-1)
                    return false;
                start=i;
            }
        }

        while(start!=-1){
            l.add(start);
            List<Integer> n=next.getOrDefault(start,new ArrayList<>());
            start=-1;
            for(int nn:n){
                num[nn]--;
                if(num[nn]==0){
                    if(start!=-1)
                        return false;
                    start=nn;
                }
            }
        }

        System.out.println(l);

        if(l.size()!=num.length)
            return false;
        for(int i=1;i<l.size();i++){
            if(l.get(i)-l.get(i-1)!=1)
                return false;
        }

        return true;
        // write your code here
    }
}
