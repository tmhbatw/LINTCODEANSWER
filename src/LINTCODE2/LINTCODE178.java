package LINTCODE2;

import java.util.LinkedHashSet;
import java.util.Set;

public class LINTCODE178 {
    /*Description
    * 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点), 写一个函数去判断这张｀无向｀图是否是一棵树
    * */

    /*Solution
    * 只有这个图一个点入度为0，其他点入度为1，就满足要求（错误，因为是无向图，无法确定哪一个是头节点）
    *这道题中判断是不是一颗树，那么首先要确定所有的点是连通的，其次要确定点的数量比边的数量大1，从而不会形成连续的环
    * 判断是否是连通的可以通过并查集方法，创建一个数组dp[],其中dp[i]的值存储它属于哪一组树
    * dp数组可以使用一个数组存储哪一个数包含的节点比较多，从而将较小的一方加入较大的一方，从而较少访问的消耗
    * 注意！注意！注意！一定要改变源头（即当前节点的根节点）的信息，不然会造成信息丢失！
    * */

    public boolean validTree(int n, int[][] edges) {
        if(n==1&&edges.length==0)
            return true;
        int[] dp=new int[n];
        int[] num=new int[n];
        for(int i=0;i<num.length;i++)
            num[i]=1;
        for(int i=0;i<dp.length;i++)
            dp[i]=i;
        Set<Integer> point=new LinkedHashSet<>();
        for(int i=0;i<edges.length;i++){
            int a=find(dp,edges[i][0]);
            int b=find(dp,edges[i][1]);
            point.add(edges[i][0]);
            point.add(edges[i][1]);
            if(num[a]>num[b]){
                num[a]+=num[b];
                dp[b]=dp[a];
            }else{
                num[b]+=num[a];
                dp[a]=dp[b];
            }
        }
        int judge=find(dp,0);
        for(int i=1;i<dp.length;i++){
            if(find(dp,i)!=judge)
                return false;
        }
        return point.size()==edges.length+1;
        // write your code here
    }
    //用来找到每一个节点所在的树的序号
    private int find(int[] dp,int n){
        while(dp[n]!=n){
            n=dp[n];
        }
        return n;
    }


    //错误尝试
/*    public boolean validTree(int n, int[][] edges) {
        int[] indegree=new int[n];
        for(int i=0;i<indegree.length;i++){
            int curr=edges[i][0];
            int cur=edges[i][1];
            if(indegree[curr]!=0&&indegree[cur]!=0){
                return false;
            }
            if(indegree[curr]==0) {
                indegree[curr]++;
            }else{
                indegree[cur]++;
            }
            n--;
        }
        return n==1;
        // write your code here
    }*/
}
