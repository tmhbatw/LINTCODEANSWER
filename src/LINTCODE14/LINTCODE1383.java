package LINTCODE14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE1383 {
    /*Description
    * 有一棵n个结点以1为根的多叉树，求这棵树的连通子图个数。
    * 由于计算的中途和答案可能会超过long的范围，故答案对10000007取模。(连通子图：任选x个点(1 <= x <= n)，任意两点能相互达到)
    * */

    int mod=10000007;
    public int getSubtreeCount(int[] start, int[] end) {
        int length=start.length+1;
        int[] time=new int[length];
        int[] father=new int[length];
        for(int i=0;i<start.length;i++){
            time[start[i]-1]++;
            father[end[i]-1]=start[i]-1;
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<length;i++)
            list.add(new ArrayList<>());

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<length;i++){
            if(time[i]==0)
                q.add(i);
        }

        long result=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            long val=1;
            for(int children:list.get(cur)){
                val*=(children+1);
                val%=mod;
            }
            val%=mod;
            list.get(father[cur]).add((int) val);
            result+=val;
            time[father[cur]]--;
            if(time[father[cur]]==0)
                q.add(father[cur]);
        }

        return (int) (result%mod);
        // Write your code here
    }
}
