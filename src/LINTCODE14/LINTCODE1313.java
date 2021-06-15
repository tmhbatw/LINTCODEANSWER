package LINTCODE14;

import java.util.PriorityQueue;

public class LINTCODE1313 {
    /*Description
    *给定一个完全图，请你把点分成两组，最小化端点为相同组的边的权值的最大值.
    * 每组的点的数量不少于2
    * */

    public int getMiniumValue(int[][] graph) {
        int n=graph.length;
        PriorityQueue<int[]> p=new PriorityQueue<>(((o1, o2) -> o2[2]-o1[2]));
        for(int i=0;i<n;i++) {
            for (int j = i + 1; j < n; j++)
                p.add(new int[]{i, j, graph[i][j]});
        }
        int[] dp=new int[n];
        int[] type=new int[n];
        for(int i=0;i<n;i++)
            type[i]=i;
        int start=1;
        while(!p.isEmpty()){
            int[] cur=p.poll();
            int i=cur[0];
            int j=cur[1];
            if(dp[i]==0&&dp[j]==0){
                dp[i]=start++;
                dp[j]=start++;
            }else if (dp[i]==0){
                int t=dp[getType(j,type)];
                int dif=getDif(t);
                int k=0;
                for(k=0;k<n;k++){
                    if(dp[k]==dif)
                        break;
                }
                type[i]=getType(k,type);
                dp[i]=dp[type[i]];
            }else if(dp[j]==0){
                int t=dp[getType(i,type)];
                int dif=getDif(t);
                int k=0;
                for(k=0;k<n;k++){
                    if(dp[k]==dif)
                        break;
                }
                type[j]=getType(k,type);
                dp[j]=dp[type[j]];
            }else{
                int type1=getType(i,type);
                int type2=getType(j,type);
                if(type1==type2)
                    return cur[2];
                int dif1=getDif(dp[type1]);
                int dif2=getDif(dp[type2]);
                int k=0;
                for(;k<n;k++){
                    if(dp[k]==dif1)
                        break;
                }
                type[type2]=getType(k,type);
                k=0;
                for(;k<n;k++){
                    if(dp[k]==dif2)
                        break;
                }
                type[type1]=getType(k,type);
            }
            int[] num=new int[n];
            for(int k=0;k<n;k++){
                num[getType(k,type)]++;
            }
            for(int k=0;k<n;k++){
                if(num[k]>n-2)
                    return cur[2];
            }
        }
        return -1;
        // write your code here.
    }

    private int getType(int i,int[] type){
        if(type[i]==i)
            return i;
        return getType(type[i],type);
    }

    private int getDif(int cur){
        return cur%2==0?cur-1:cur+1;
    }
}
