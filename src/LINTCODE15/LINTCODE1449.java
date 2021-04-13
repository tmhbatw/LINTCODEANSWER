package LINTCODE15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1449 {
    /*Description
    *在一组 N 个人（编号为 0, 1, 2, ..., N-1）中，每个人都有不同数目的钱，以及不同程度的安静（quietness）。
    * 为了方便起见，我们将编号为 x 的人简称为 "person x "。
    * 如果能够肯定 person x 比 person y 更有钱的话，我们会说 richer[i] = [x, y] 。注意 richer 可能只是有效观察的一个子集。
    * 另外，如果 person x 的安静程度为 q ，我们会说 quiet[x] = q 。
    * 现在，返回答案 answer ，其中 answer[x] = y 的前提是，在所有拥有的钱不少于 person x 的人中，
    * person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
    * */


    boolean[] reached;
    int[] result;
    Map<Integer, List<Integer>> map;
    int[] quiet;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        map=new HashMap<>();
        for(int[] cur:richer){
            if(!map.containsKey(cur[1]))
                map.put(cur[1],new ArrayList<>());
            List<Integer> list=map.get(cur[1]);
            list.add(cur[0]);
        }
        int length=quiet.length;
        result=new int[length];
        reached=new boolean[length];
        this.quiet=quiet;
        for(int i=0;i<length;i++){
            dfs(i);
        }
        return result;
        // Write your code here.
    }

    private int dfs(int index){
        if(reached[index])
            return result[index];
        int result=index;
        int curQuiet=quiet[index];
        List<Integer> list=map.getOrDefault(index,new ArrayList<>());
        for(int cur:list){
            int curIndex=dfs(cur);
            if(quiet[curIndex]<curQuiet){
                curQuiet=quiet[curIndex];
                result=curIndex;
            }
        }
        reached[index]=true;
        this.result[index]=result;
        return result;
    }
}
