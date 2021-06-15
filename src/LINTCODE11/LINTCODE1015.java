package LINTCODE11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1015 {
    /*Description
    * 在一个有向图中，我们从某个节点开始，每次沿着图的有向边走。 如果我们到达一个出度为0的点，
    * 则停止，我们将这些出度为0的点称为"终端节点"。
    * 一个"最终安全的节点"被定义为：如果以这个节点作为起点，不论以何种路径，都会在有限的步数内到达一个"终端节点"。
    * 你的程序应返回一个有序数组，代表你找到的"最终安全的节点"的标号。图的节点下标从0开始。
    * graph[i]代表图中节点 i 的所有邻居节点下标。
    * */

    int[][] graph;
    boolean[] reached;
    boolean[] isFinalNode;
    boolean[] waited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        this.graph=graph;
        this.reached=new boolean[n];
        this.isFinalNode=new boolean[n];
        this.waited=new boolean[n];
        for(int i=0;i<n;i++){
            dfs(i);
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isFinalNode[i])
                result.add(i);
        }
        return result;
        // write your code here
    }

    private boolean dfs(int idx){
        if(reached[idx]){
            return isFinalNode[idx];
        }
        waited[idx]=true;
        boolean flag=true;
        for(int next:graph[idx]){
            if(waited[next]){
                flag=false;
                continue;
            }
            if(!dfs(next))
                flag=false;
        }
        waited[idx]=false ;
        reached[idx]=true;
        isFinalNode[idx]=flag;
        return flag;
    }
}
