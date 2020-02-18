package LINTCODE14;

import java.util.*;

public class LINTCODE1373 {
    /*Description
    * 您正在乘飞机，想在此飞行中看两部电影。
    * 您将获得List movieDurations，这个list中包括所有电影时长。
    * 您还将获得飞行时间d，以分钟为单位。
    * 现在，您需要选择两部电影，并且两部电影的总时长小于或等于（d-30min）。
    * 查找总时长最长的电影，并返回它们的索引。 如果找到多个，则返回电影最长的那对。
    * */

    public int[] FlightDetails(int[] arr, int k) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> cur=map.getOrDefault(arr[i],new ArrayList<>());
            cur.add(i);
            map.put(arr[i],cur);
        }
        Arrays.sort(arr);
        k-=30;
        int left=0;
        int right=arr.length-1;
        int[] result=new int[2];
        int curRes=0;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum>k)
                right--;
            else{
                if(sum>curRes){
                    curRes=sum;
                    result[0]=left;
                    result[1]=right;
                }
                left++;
            }
        }
        if(result[0]==result[1]){
            List<Integer> list=map.get(arr[result[0]]);
            result[0]=list.get(0);
            result[1]=list.get(1);
        }else{
            result[0]=map.get(arr[result[0]]).get(0);
            result[1]=map.get(arr[result[1]]).get(0);
            if(result[0]>result[1]){
                int temp=result[1];
                result[1]=result[0];
                result[0]=temp;
            }
        }
        return result;
        // write your code here
    }
}
