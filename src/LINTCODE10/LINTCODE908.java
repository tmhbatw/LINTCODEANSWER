package LINTCODE10;

import java.util.*;

public class LINTCODE908 {
    /*Description
    * 给定二维平面上的n点，请问是否有这样一条与y轴平行的线使所有点对称。
    * */

    public boolean isReflected(int[][] points) {
        TreeMap<Integer, List<Integer>> map=new TreeMap<>();
        for(int[] cur:points){
            map.putIfAbsent(cur[0],new ArrayList<>());
            List<Integer> list=map.get(cur[0]);
            list.add(cur[1]);
        }
        double mid=Double.MAX_VALUE;
        while(map.size()>=2){
            int lastKey=map.lastKey();
            int firstKey=map.firstKey();
            double curMid=(lastKey+firstKey)*1.0/2;
            if(mid==Double.MAX_VALUE)
                mid=curMid;
            else {
                if (curMid != mid)
                    return false;
            }
            List<Integer> lastList=map.remove(lastKey);
            List<Integer> firstList=map.remove(firstKey);
            if(lastList.size()!=firstList.size())
                return false;
            Collections.sort(lastList);
            Collections.sort(firstList);
            for(int i=0;i<lastList.size();i++){
                if(!lastList.get(i).equals(firstList.get(i)))
                    return false;
            }
        }
        if(!map.isEmpty()){
            int key=map.firstKey();
            return mid==Double.MAX_VALUE||key == mid;
        }
        return true;
        // Write your code here
    }
}
