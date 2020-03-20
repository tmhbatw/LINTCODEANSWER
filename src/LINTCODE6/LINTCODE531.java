package LINTCODE6;

import datastructure.UndirectedGraphNode;

import java.util.*;

public class LINTCODE531 {
    /*Description
    * 六度分离是一个哲学问题，说的是每个人每个东西可以通过六步或者更少的步数建立联系。
    * 现在给你一个友谊关系，查询两个人可以通过几步相连，如果不相连返回 -1
    * */

    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        if(s==t)
            return 0;
        Set<UndirectedGraphNode> set=new HashSet<>();
        set.add(s);
        queue.add(s);
        int time=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            time++;
            for(int i=0;i<size;i++) {
                UndirectedGraphNode node = queue.poll();
                List<UndirectedGraphNode> list = node.neighbors;
                for (UndirectedGraphNode cur:list){
                    if(cur==t)
                        return time;
                    if(!set.contains(cur)){
                        set.contains(cur);
                        queue.add(cur);
                    }
                }
            }
        }
        return -1;
        // write your code here
    }
}
