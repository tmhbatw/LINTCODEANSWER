package LINTCODE15;

import java.util.*;

public class LINTCODE1450 {
    /*Description
    * 我们给出了一个（轴对齐的）矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，
    * 其中（x1，y1）是矩形 i 左下角的坐标，（x2，y2）是该矩形右上角的坐标。
    * 找出平面中所有矩形叠加覆盖后的总面积。 由于答案可能太大，请返回它对 10 ^ 9 + 7 取模的结果。
    * */

    public int rectangleArea(int[][] rectangles) {
        Map<Integer, List<Integer>> map=new TreeMap<>();
        for(int[] cur:rectangles){
            map.putIfAbsent(cur[0],new ArrayList<>());
            map.putIfAbsent(cur[2],new ArrayList<>());
            map.get(cur[0]).add(-(cur[3]+1));
            map.get(cur[0]).add(cur[0]+1);
            map.get(cur[2]).add(-(cur[0]+1));
            map.get(cur[2]).add(cur[3]+1);
        }
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        int preX=0;
        long result=0;
        int mod=1000000007;
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            int curX=entry.getKey();
            int sumY=0;
            int preY=0;
            int count=0;
            for(Map.Entry<Integer,Integer> e2:treeMap.entrySet()){
                if(count==0){
                    count=e2.getValue();
                    preY=e2.getKey();
                }else{
                    count+=e2.getValue();
                    if(count==0){
                        sumY+=e2.getKey()-preY;
                    }
                }
            }
            result += (long)sumY*(curX-preX)%mod;
            preX=curX;
            List<Integer> list=entry.getValue();
            for(int cur:list){
                if(cur>0)
                    treeMap.put(cur,treeMap.getOrDefault(cur,0)+1);
                if(cur<0)
                    treeMap.put(cur,treeMap.getOrDefault(cur,0)-1);
            }
        }
        return (int) (result%mod);
        // write your code here
    }
}
