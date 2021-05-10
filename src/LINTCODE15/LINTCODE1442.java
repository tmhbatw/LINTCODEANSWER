package LINTCODE15;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE1442 {
    /*Description
    * 现在有一个订单，对n 种商品有需求，对第 i 种商品的需求为 order[i] 个。工厂有 m 种生产模式，
    * 每种生产模式形如 [p[1],p[2],...p[n]] ，即同时生产第 1 种商品 p[1] 个，第 2 种商品 p[2] 个……你可以使用多种生产模式，
    * 请问在不超过任意一种商品的需求的情况下，未满足需求的商品最少有多少个?
    * */

    //bfs算法试试
/*
    public int getMinRemaining(int[] order, int[][] pattern) {
        int m=pattern.length;
        Queue<int[]> q=new LinkedList<>();
        q.add(order);
        Set<Long> set=new HashSet<>();
        for(int i=0;i<m;i++){
            int size=q.size();
            while(size-->0) {
                int[] curOrder = q.poll();
                if(isReached(set,curOrder,m+1))
                    continue;
                q.add(curOrder.clone());
                while(isMatch(curOrder,pattern[i]))
                    q.add(curOrder.clone());
            }
        }
        int result=Integer.MAX_VALUE;
        for(int[] cur:q){
            int curRes=0;
            for(int curr:cur)
                curRes+=curr;
            result=Math.min(curRes,result);
        }
        return result;
        // Write your code here
    }

    private boolean isReached(Set<Long> set,int[] order,int m){
        long base=1;
        long val=0;
        for(int cur:order){
            val+=base*cur;
            base*=10;
        }
        if(set.contains(val))
            return true;
        set.add(val*m);
        return false;
    }

    private boolean isMatch(int[] order,int[] pattern){
        for(int i=0;i<order.length;i++){
            if(order[i]<pattern[i])
                return false;
            order[i]-=pattern[i];
        }
        return true;
    }
*/

    //dfs会造成栈溢出
    int result=0;
    public int getMinRemaining(int[] order, int[][] pattern) {
        for(int cur:order)
            result+=cur;
        dfs(order,pattern,0);
        return result;
        // Write your code here
    }

    private void dfs(int[] order,int[][] pattern, int index){
        if(index==pattern.length){
            int curRes=0;
            for(int cur:order){
                curRes+=cur;
            }
            result=Math.min(result,curRes);
            return;
        }
        for(int i=0;i<pattern[index].length;i++) {
            if(pattern[index][i]!=0)
                break;
            if(i==pattern[index].length-1) {
                dfs(order, pattern, index + 1);
                return ;
            }
        }
        int[] curOrder=order.clone();
        for(int i=0;i<pattern[index].length;i++){
            if(curOrder[i]>=pattern[index][i])
                curOrder[i]-=pattern[index][i];
            else
                break;
            if(i==pattern[index].length-1)
                dfs(curOrder,pattern,index);
        }
        dfs(order,pattern,index+1);
    }


}
