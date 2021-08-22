package LINTCODE11;

import java.util.*;

public class LINTCODE1092 {
    /*Description
    * 为了高尔夫赛事，你被要求修剪森林当中的树。森林被表示为一个非负的2D地图，在这张地图当中：
    * 0代表不能到达的障碍
    * 1代表可以通过的地面
    * 大于1的地方代表可以通过的一棵树，这个整数代表树的高度。
    * 你被要求去修剪在森林当中的所有树，按照树的高度——总是首先剪掉最小高度的树。
    * 在修剪完后，一开始有树的地方变成了草（值为1）。
    *  你从点(0, 0)开始，然后你应该输出剪掉所有的树你需要走的最小的步数。
    * 如果你不能够剪掉所有的树，在这种情况下输出-1。
    * 数据保证不存在两颗树具有相同的高度，并且至少有一棵需要被砍掉的树。
    * */

    int m,n;
    public int cutOffTree(List<List<Integer>> forest) {
        this.m=forest.size();
        this.n= forest.get(0).size();
        int[][] board=new int[m][n];
        PriorityQueue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=forest.get(i).get(j);
                if(board[i][j]>1)
                    q.add(new int[]{i,j,board[i][j]});
            }
        }
        int[] start=new int[]{0,0};
        int result=0;
        while(!q.isEmpty()){
            int cur=getDistance(start,board,q.peek());
            if(cur==-1)
                return -1;
            result+=cur;
            start=q.poll();
        }
        return result;
        // write your code here
    }

    private int getDistance(int[] start, int[][] board, int[] target){
        if(start[0]==target[0]&&start[1]==target[1])
            return 0;
        boolean[][] reached=new boolean[m][n];
        reached[start[0]][start[1]]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0) {
                int[] cur = q.poll();
                for (int[] next : nextPos) {
                    int i = next[0] + cur[0];
                    int j = next[1] + cur[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && !reached[i][j]) {
                        if (i == target[0] && j == target[1]) {
                            board[i][j] = 1;
                            return distance;
                        }
                        if (board[i][j] == 1) {
                            q.add(new int[]{i, j});
                            reached[i][j] = true;
                        }
                    }
                }
            }
            distance++;
        }
        return -1;
    }


}
