package LINTCODE9;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LINTCODE821 {
    /*Description
    * 目前有两个用户的有序在线时间序列，每一个区间记录了该用户的登录时间点x和离线时间点y，
    * 请找出这两个用户同时在线的时间段，输出的时间段请从小到大排序。你需要返回一个intervals的列表
    * */

    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        Comparator<Interval> comparator=new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        };
        seqA.sort(comparator);
        seqB.sort(comparator);
        int numberA=seqA.size();
        int numberB=seqB.size();
        int indexA=0;
        int indexB=0;
        List<Interval> result=new ArrayList<>();
        while(indexA<numberA&&indexB<numberB){
            Interval iA=seqA.get(indexA);
            Interval iB=seqB.get(indexB);
            if(iA.end<=iB.start) {
                indexA++;
                continue;
            }
            if(iB.end<=iA.start){
                indexB++;
                continue;
            }
            if(iA.end<=iB.end&&iA.start>=iB.start){
                result.add(iA);
                indexA++;
                continue;
            }
            if(iB.end<=iA.end&&iB.start>=iA.start){
                result.add(iB);
                indexB++;
                continue;
            }
            if(iA.end>=iB.end){
                result.add(new Interval(iA.start,iB.end));
                indexB++;
                continue;
            }
            result.add(new Interval(iB.start,iA.end));
            indexA++;
        }
        return result;
        // Write your code here
    }
}
