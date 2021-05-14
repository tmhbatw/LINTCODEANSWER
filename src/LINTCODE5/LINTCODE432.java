package LINTCODE5;

import datastructure.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE432 {
    /*Description
    * 请找出有向图中弱连通分量。图中的每个节点包含 1 个标签和1 个相邻节点列表。
    * （有向图的弱连通分量是任意两点均有有向边相连的极大子图）
    * */

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        int n=nodes.size();
        Map<Integer,Integer> type=new HashMap<>();
        Map<Integer,Integer> time=new HashMap<>();
        for(DirectedGraphNode node:nodes){
            int label=node.label;
            type.put(label,label);
            time.put(label,1);
        }
        for(DirectedGraphNode node:nodes){
            List<DirectedGraphNode> list=node.neighbors;
            int label=node.label;
            int lType=getType(type,label);
            for(DirectedGraphNode next:list){
                int curL=next.label;
                int curType=getType(type,curL);
                if(time.get(lType)>=time.get(curType)){
                    type.put(curType,lType);
                    time.put(lType,time.get(lType)+time.get(curType));
                }else{
                    type.put(lType,curType);
                    time.put(curType,time.get(curType)+time.get(lType));
                    lType=curType;
                }
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(DirectedGraphNode node:nodes){
            int i=node.label;
            int curType=getType(type,i);
            if(!map.containsKey(curType)){
                List<Integer> l=new ArrayList<>();
                map.put(curType,l);
                list.add(l);
            }
            List<Integer> l=map.get(curType);
            l.add(i);
        }
        return list;
        // write your code here
    }

    private int getType(Map<Integer,Integer> type,int cur){
        if(type.get(cur)==cur)
            return cur;
        return getType(type,type.get(cur));
    }


}
