package LINTCODE12;

import java.util.*;

public class LINTCODE1130 {
    /*Description
    * 小明和小华，终于来到了邪恶的魔法师的摆的魔法阵前。只见这个魔法阵由n颗宝石围成一个圆组成。
    * 而想要摧毁魔法阵，只能将宝石摧毁，对魔法阵造成冲击。经过计算，小明得知了每颗宝石蕴含的能量，
    * 并且知道自己和小华只有一次出手的机会，两人可以同时摧毁两颗宝石，
    * 对魔法阵造成的冲击将会是两颗宝石的能量之和再加上两颗宝石在圆上的距离。所谓圆上的距离是指，
    * 相邻两颗宝石的圆弧算作是1，两颗宝石在圆上的劣弧算作它们的距离。
    *
    * 现在需要你求出，对魔法阵造成最大冲击的量是多少，以及造成这个量的方案有多少(小明和小华位置互换算作一种方案)。
    * */

    /*Solution
    * 顺序情况 data[j]+data[j]+data[i]-i
    * 逆序情况 data[j]-j+n+data[i]+i
    * */

    int result=0;
    int time=0;

    public List<Integer> MagicCircle(int[] gems) {
        int length=gems.length;
        int midLength=(length+1)/2;//小于等于i-midLength时，将其从顺序情况转化为逆序情况

        TreeMap<Integer,Integer> inOrderMap=new TreeMap<>();
        TreeMap<Integer,Integer> reverseOrderMap=new TreeMap<>();
        for(int i=0;i<length;i++){
            //将顺序情况转化为逆序情况
            if(i>=midLength){
                int changeIndex=i-midLength;
                inOrderMap.put(gems[changeIndex]-changeIndex,inOrderMap.get(gems[changeIndex]-changeIndex)-1);
                if(inOrderMap.get(gems[changeIndex]-changeIndex)==0)
                    inOrderMap.remove(gems[changeIndex]-changeIndex);
                reverseOrderMap.put(gems[changeIndex]+changeIndex,
                        reverseOrderMap.getOrDefault(gems[changeIndex]+changeIndex,0)+1);
            }
            getMax(inOrderMap,gems[i]+i);
            getMax(reverseOrderMap,gems[i]+length-i);

            inOrderMap.put(gems[i]-i,inOrderMap.getOrDefault(gems[i]-i,0)+1);
        }

        List<Integer> res=new ArrayList<>();
        res.add(result);
        res.add(time);
        return res;
        // write your code here
    }

    private void getMax(TreeMap<Integer,Integer> map,int add){
        if(!map.isEmpty()){
            int key=map.floorKey(Integer.MAX_VALUE);
            int time=map.get(key);
            if(key+add>result){
                result=key+add;
                this.time=time;
            }else if(key+add==result)
                this.time+=time;
        }
    }
}
