package LINTCODE8;

import java.util.*;

public class LINTCODE783 {
    /*Description
    * 地图上有 m 条无向边，每条边 (x, y, w) 表示位置 x 到位置 y 的权值为 w。
    * 从位置 0 到 位置 n 可能有多条路径。我们定义一条路径的危险值为这条路径中所有的边的最大权值。
    * 请问从位置 0 到 位置 n 所有路径中最小的危险值为多少？
    * */

    class Node{
        int pos;
        int val;
        public Node(int pos, int val){
            this.pos = pos;
            this.val = val;
        }

        public String toString(){
            return this.pos+" "+this.val;
        }
    }

    public int getMinRiskValue(int n, int m, int[] x, int[] y, int[] w) {
        int size=0;
        Map<Integer,List<Node>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.putIfAbsent(x[i],new ArrayList<>());
            map.putIfAbsent(y[i],new ArrayList<>());
            map.get(x[i]).add(new Node(y[i],w[i]));
            map.get(y[i]).add(new Node(x[i],w[i]));
            size=Math.max(size,Math.max(x[i],y[i]));
        }
        int[] res=new int[size+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[0]=0;
        Queue<Node> q=new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        q.add(new Node(0,0));
        while(!q.isEmpty()){
            Node cur=q.poll();
            int curPos=cur.pos;
            int curVal=cur.val;
            if(curPos==m)
                return curVal;
            //说明已经遍历过了
            if(curVal>res[curPos])
                continue;
            List<Node> list=map.get(curPos);
            for(Node next:list){
                int nextPos=next.pos;
                int nextVal=Math.max(curVal,next.val);
                if(res[nextPos]<=nextVal)
                    continue;
                res[nextPos]=nextVal;
                q.add(new Node(nextPos,nextVal));
            }
        }
        return res[n];
        //
    }

}
