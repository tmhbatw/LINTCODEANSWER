package LINTCODE14;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class LINTCODE1316 {



    public int luckNumber(int[] arr) {
        TreeMap<Integer,Integer> map=new TreeMap();
        for(int cur:arr)
            map.put(cur,map.getOrDefault(cur,0)+1);
        TreeSet<Integer> map2=new TreeSet<>();
        int res=0;
        for(int cur:arr){
            map2.add(cur);
            Integer big=map2.ceiling(cur+1);
            Integer small=map.floorKey(cur-1);
            System.out.println(map2);
            System.out.println(map);
            System.out.println(big+" "+small);
            if(big!=null&&small!=null&&big%small==0)
                res++;
            if(map.get(cur)==1)
                map.remove(cur);
            else
                map.put(cur,map.get(cur)-1);
        }
        return res;
        // Write your code here.
    }

    public static void main(String[] args){
        TreeSet<Integer> set=new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.ceiling(2));
        System.out.println(set.floor(2));
    }
}
