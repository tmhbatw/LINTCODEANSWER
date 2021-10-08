package LINTCODE15;

import java.util.*;

public class LINTCODE1422 {
    /*Description
    * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。
    * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
    * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
    * */
    class Node{
        int val;
        Set<Integer> set;
        public Node(int val,Set<Integer> set){
            this.val=val;
            this.set=set;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int length=graph.length;
        Map<Integer,Set<Set<Integer>>> exist=new HashMap<>();

        for(int i=0;i<length;i++) {
            exist.put(i,new HashSet<>());
        }

        Queue<Node> q=new LinkedList<>();
        int result=0;
        for(int i=0;i<length;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<length;j++)
                set.add(j);
            set.remove(i);
            q.add(new Node(i,set));
            exist.get(i).add(set);
        }

        while(!q.isEmpty()){
            result++;
            int size=q.size();
            for(int i=0;i<size;i++){
                Node cur=q.poll();
                int[] next=graph[cur.val];
                for(int n:next){
                    Set<Integer> nextSet=new HashSet<>(cur.set);
                    nextSet.remove(n);
                    if(nextSet.size()==0)
                        return result;
                    if(exist.get(n).contains(nextSet))
                        continue;
                    exist.get(n).add(nextSet);
                    q.add(new Node(n,nextSet));
                }
            }
        }
        return 0;
        // Write your code here.
    }

    public static void main(String[] args){
        Set<Set<Integer>> set=new HashSet<>();
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        set.add(set1);
        Set<Integer> set2=new HashSet<>();
        set2.add(1);
        set.add(set1);
        System.out.println(set.size());
    }
}
