package LINTCODE9;

import java.util.*;

public class LINTCODE808 {
    /*Description
    * 给一些movie（编号从0开始）的rating和他们的联系关系，联系关系可以传递(a和b有联系，b和c有联系，a和c也认为有联系)。
    * 给出每个movie的直接联系list。再给定一个movie编号为S，找到和S相联系的movie中的rating最高的K个movie
    * （当与S相联系的movie少于K个时，输出所有。输出答案时可以按照任意次序，注意联系movie并不包括S。）
    * */

    class Pair{
        int index;
        int rating;
        public Pair(int index,int rating){
            this.index=index;
            this.rating=rating;
        }
    }

    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        HashSet<Integer> set=new HashSet<>();
        set.add(S);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(S);
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.rating-o2.rating;
            }
        });
        while(!queue.isEmpty()){
            int cur=queue.poll();
            int[] neighborList=G[cur];
            for(int neighbor:neighborList){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    pq.add(new Pair(neighbor,rating[neighbor]));
                    if(pq.size()==K+1)
                        pq.poll();
                    queue.add(neighbor);
                }
            }
        }
        int[] result=new int[pq.size()];
        for(int j=result.length-1;j>=0;j--){
            result[j]=pq.poll().index;
        }
        return result;
        // Write your code here
    }
}
