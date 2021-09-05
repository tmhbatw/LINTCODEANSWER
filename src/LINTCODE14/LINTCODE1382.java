package LINTCODE14;

import java.util.*;

public class LINTCODE1382 {
    /*Description
    * 给出一个背包容量s, 给出n件物品，第i件物品的价值为vi，第i件物品的体积为ci，
    * 问这个背包最多能装多少的价值的物品，输出这个最大价值。(每个物品只能用一次)
    * */

    List<int[]> list1=new ArrayList<>();
    List<int[]> list2=new ArrayList<>();
    public long getMaxValue(int s, int[] v, int[] c) {
        if(v.length==1)
            return c[0]<=s?v[0]:0;
        int mid=v.length/2;
        dfs(s,v,c,list1,0,mid,0,0);
        dfs(s,v,c,list2,mid,v.length,0,0);
        list1=screen(list1);
        list2=screen(list2);
        int index=list2.size()-1;
        int result=0;
        for (int[] ints : list1) {
            while (ints[0] + list2.get(index)[0] > s)
                index--;
            result = Math.max(ints[1] + list2.get(index)[1], result);
        }
        return result;
        // Write your code here
    }

    private List<int[]> screen(List<int[]> list){
        list.sort((o1,o2)->{
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];
        });
        List<int[]> result=new ArrayList<>();
        int val=-1;
        for(int[] cur:list){
            if(cur[1]>val){
                result.add(cur);
                val=cur[1];
            }
        }
        return result;
    }

    public void dfs(int s, int[] v, int[] c,List<int[]> list1, int index, int end,int cur,int val){
        if(index==end){
            list1.add(new int[]{cur,val});
            return;
        }
        dfs(s,v,c,list1,index+1,end,cur,val);
        if(cur+c[index]<=s){
            dfs(s,v,c,list1,index+1,end,cur+c[index],val+v[index]);
        }
    }

    public static void main(String[] args){
        int i= (int) Math.pow(2,31);
        System.out.println(i);
    }
}
