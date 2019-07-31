package LINTCODE6;

public class LINTCODE553 {
    /*Description
    *给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'),
    * 返回你可以用一个炸弹杀死的最大敌人数. 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁.
    * */

    public int maxKilledEnemies(char[][] grid) {
        if(grid.length==0)
            return 0;
        int[][] num=new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    int ii = i, jj = j;
                    while (--ii >= 0) {
                        if (grid[ii][jj] == 'W')
                            break;
                        if (grid[ii][jj] == 'E')
                            continue;
                        num[ii][jj] += 1;
                    }
                    ii = i;
                    while (++ii <= grid.length - 1) {
                        if (grid[ii][jj] == 'W')
                            break;
                        if (grid[ii][jj] == 'E')
                            continue;
                        num[ii][jj] += 1;
                    }
                    ii = i;
                    while (++jj <= grid[0].length - 1) {
                        if (grid[ii][jj] == 'W')
                            break;
                        if (grid[ii][jj] == 'E')
                            continue;
                        num[ii][jj] += 1;
                    }
                    jj = j;
                    while (--jj >= 0) {
                        if (grid[ii][jj] == 'W')
                            break;
                        if (grid[ii][jj] == 'E')
                            continue;
                       num[ii][jj] += 1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res=Math.max(num[i][j],res);
            }
        }
        return res;
    }
        // write your code here
}
