package LINTCODE10;

public class LINTCODE909 {
    /*Descripiton
    * 给定一个Android 3x3锁定屏幕和两个整数m和n,其中1≤m≤n≤9,统计可以解锁Android锁定屏幕所有有效模式的总数,包括最少的m个键和最多n个键。
    * 有效模式的规则:
    * 每个模式必须连接至少m个键和最多n个键。
    * 所有的键都必须是不同的。
    * 如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择。不允许跳过非选择键。
    * 钥匙的顺序很重要。
    * */

    int m;
    int n;
    int result=0;
    int[][] next=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numberOfPatterns(int m, int n) {
        this.m=m;
        this.n=n;
        boolean[][] reached=new boolean[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                dfs(i,j,reached,0);
            }
        }
        return result;
        // Write your code here
    }
    private void dfs(int i,int j, boolean[][] reached,int cur){
        reached[i][j] = true;
        int c = cur+1;
        if(c<=m&&c>=n)
            result++;

    }
}
