package LINTCODE8;

public class LINTCODE795 {
    /*Description
    * 一个机器人位于一个m*n的网格的左上角。
    * 机器人可以在任何时间点移动任何方向，但是每个网格只能达到一次。机器人正试图到达网格的右下角。
    * 有多少种可能的独特路径?
    * */

    boolean[][] reached;
    int result;
    int[][] pos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        reached=new boolean[m][n];
        result=0;
        this.m=m;
        this.n=n;
        dfs(0,0);
        return result;
        // Write your code here
    }

    private void dfs(int m,int n){
        if(m==this.m-1&&n==this.n-1){
            result++;
            return;
        }
        for(int[] nextPos:pos){
            int mm=m+nextPos[0];
            int nn=n+nextPos[1];
            if(mm>=0&&nn>=0&&mm<this.m&&nn<this.n&&!reached[mm][nn]){
                reached[mm][nn]=true;
                dfs(mm,nn);
                reached[mm][nn]=false;
            }
        }
    }
}
