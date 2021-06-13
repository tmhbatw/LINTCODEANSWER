package LINTCODE8;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE751 {
    /*description
    * 在一条数轴上，有n个城市，编号从0 ~ n – 1 , 约翰打算在这n个城市做点生意，他对Armani的一批货物感兴趣，
    * 每个城市对于这批货物都有一个价格prices[i]。对于城市x,约翰可从城市编号为[x - k, x + k]购买货物，然后卖到城市x,问约翰在每个城市最多能赚到多少钱？
    * * */

    public int[] business(int[] A, int k) {
        int length=A.length;
        int[] res = new int[length];
        if(k>=length-1){
            int min=Integer.MAX_VALUE;
            for(int cur:A)
                min=Math.min(cur,min);
            for(int i=0;i<length;i++)
                res[i]=A[i]-min;
            return res;
        }
        Deque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            int cur=A[i];
            while(!q.isEmpty()&&q.peekLast()[1]>cur)
                q.pollLast();
            q.add(new int[]{i,cur});
        }
        for(int i=0;i<length;i++){
            if(i-k>=0&&q.peekFirst()[0]==i-k)
                q.pollFirst();
            if(i+k<length){
                int cur=A[i+k];
                while(!q.isEmpty()&&q.peekLast()[1]>cur)
                    q.pollLast();
                q.add(new int[]{i+k,cur});
            }
            res[i]=q.peekFirst()[1]-A[i];
        }
        return res;
        //
    }
}
