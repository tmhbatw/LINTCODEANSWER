package LINTCODE11;

public class LINTCODE1010 {
    /*Description
    *二维数组grid表示一个城市，其中grid[i][j]表示所在位置的建筑物高度。
    * 我们可以为任意数量建筑物增加任意高度（不同建筑物的增加高度可以不同）。 高度为0也被认为是建筑物。
    * 最后，当从城市的四个方向（即东西南北）观察时，观察到的“轮廓”必须与初始时相同。
    * 城市的“轮廓”是从远处看到的由所有建筑物形成的矩形外部轮廓。（参见示例）
    * 建筑物可以增加的最大高度总和是多少？
    * */

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row=new int[grid.length];
        for(int i=0;i<grid.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<grid[0].length;j++)
                max=Math.max(max,grid[i][j]);
            row[i]=max;
        }
        int[] col=new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<grid.length;j++)
                max=Math.max(max,grid[j][i]);
            col[i]=max;
        }
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                result+=Math.min(row[i],col[j])-grid[i][j];
            }
        }
        return result;
        // Write your code here
    }
}
