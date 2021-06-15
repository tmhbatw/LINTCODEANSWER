package LINTCODE15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE1418 {
    /*Description
    *给定具有R行和C列的整数矩阵，请找到一条起点为[0,0]，终点为[r-1,c-1]，且路径分数最大的路径。
    * 其中路径分数是指该路径中的经过最小值。 例如，路径8→4→5→9的路径分数为4。
    * 你只能从当前位置向上下左右这四个方向行走，不能斜向行走，且走过的点不能重复。
    * */
    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<int[]> q=new PriorityQueue<>((o1, o2) -> o2[2]-o1[2]);
        int m=A.length,n=A[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                q.add(new int[]{i,j,A[i][j]});
        }
        int[][] next=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int[] dp=new int[100*100];
        for(int i=0;i<10000;i++)
            dp[i]=-1;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            List<Integer> list=new ArrayList<>();
            list.add(cur[0]*100+cur[1]);
            dp[cur[0]*100+cur[1]]=cur[0]*100+cur[1];
            for(int[] nextPos:next){
                int ii=nextPos[0]+cur[0];
                int jj=nextPos[1]+cur[1];
                if(ii>=0&&ii<m&&jj>=0&&jj<n){
                    if(dp[ii*100+jj]==-1)
                        continue;
                    list.add(getType(ii,jj,dp));
                }
            }
            Collections.sort(list);
            for(int i=1;i<list.size();i++){
                dp[list.get(i)]=list.get(0);
            }
            if(dp[0]!=-1&&dp[(m-1)*100+(n-1)]!=-1
                    &&getType(0,0,dp)==getType(m-1,n-1,dp))
                return cur[2];
        }
        return -1;
        // Write your code here
    }

    private int getType(int i,int j, int[] dp){
        int type=i*100+j;
        return getType(type,dp);
    }

    private int getType(int type,int[] dp){
        if(dp[type]==type)
            return type;
        return getType(dp[type],dp);
    }
}
