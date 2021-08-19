package LINTCODE7;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE679 {
    /*Description
    * 在这题里，我们会给你一个有权值的地图，你需要找到所有权值不同的路径之和。
    * */

    public int uniqueWeightedPaths(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;
        int m=grid.length, n=grid[0].length;
        Set<Integer>[][] set=new Set[m][n];
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                set[i][j] = new HashSet<>();
                if (i == 0 && j == 0)
                    set[i][j].add(grid[0][0]);
                else {
                    if (i > 0) {
                        for (int cur : set[i - 1][j])
                            set[i][j].add(grid[i][j] + cur);
                    }
                    if (j > 0) {
                        for (int cur : set[i][j - 1])
                            set[i][j].add(grid[i][j] + cur);
                    }
                }
            }
        }
        int res=0;
        for(int cur:set[m-1][n-1])
            res+=cur;
        return res;
        // write your codes here
    }
}
