package LINTCODE7;

import java.util.*;

public class LINTCODE622 {
    /*Description
    * 一只青蛙正要过河，这条河分成了 x 个单位，每个单位可能存在石头，青蛙可以跳到石头上，但它不能跳进水里。
    * 按照顺序给出石头所在的位置，判断青蛙能否到达最后一块石头所在的位置。刚开始时青蛙在第一块石头上，假设青蛙第一次跳只能跳一个单位的长度。
    * 如果青蛙最后一个跳 k 个单位，那么它下一次只能跳 k - 1 ，k 或者 k + 1 个单位。注意青蛙只能向前跳。
    * */


    public boolean canCross(int[] stones) {
        if(stones.length<=1)
            return true;
        if(stones[1]!=1)
            return false;

        List<Set<Integer>> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<stones.length;i++){
            list.add(new HashSet<>());
            map.put(stones[i],i);
        }
        list.get(1).add(1);
        for(int i=1;i<stones.length;i++){
            Set<Integer> set=list.get(i);
            for(int cur:set){
                for(int add=-1;add<=1;add++){
                    int step=cur+add;
                    if(step==0)
                        continue;
                    if(map.containsKey(step+stones[i])){
                        list.get(map.get(step+stones[i])).add(step);
                    }
                }
            }
        }
        return !list.get(stones.length-1).isEmpty();
        // write your code here
    }


}
