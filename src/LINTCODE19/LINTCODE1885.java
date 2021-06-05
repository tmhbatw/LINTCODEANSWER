package LINTCODE19;

import java.math.BigInteger;
import java.util.*;

public class LINTCODE1885 {

    public List<String> strangeSort(List<Integer> mapping, List<String> nums) {
        Point[] point=new Point[nums.size()];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<mapping.size();i++)
            map.put(mapping.get(i),i);
        for(int i=0;i<nums.size();i++){
           BigInteger num=getNum(nums.get(i),map);
            point[i]= new Point(nums.get(i), num, i);
        }
        Arrays.sort(point,(o1,o2)->{
            if(o1.num.equals(o2.num))
                return o1.index-o2.index;
            return o1.num.compareTo(o2.num);
        });
        List<String> result=new ArrayList<>();
        for(Point cur:point){
            result.add(cur.nums);
        }
        return result;
        // write your code here
    }

    private BigInteger getNum(String nums,Map<Integer,Integer> map){
        BigInteger num=new BigInteger(String.valueOf(0));
        for(int i=0;i<nums.length();i++){
            int cur=map.get(nums.charAt(i)-'0');
            num=num.multiply(new BigInteger(String.valueOf(10)));
            num=num.add(new BigInteger(String.valueOf(cur)));
        }
        return num;
    }

    static class Point{
        String nums;
        BigInteger num;
        int index;
        public Point(String nums,BigInteger num,int index){
            this.nums=nums;
            this.num=num;
            this.index=index;
        }
    }

}
