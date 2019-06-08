package LINTCODE4;

import java.util.PriorityQueue;

public class LINTCODE364 {
    /*Description
     * Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1,
     * compute how much water it is able to trap after raining.
     * */

    /*Solution
    * 用一个boolean数组来存储每一个位置是否被遍历过
    * 创建一个通过比较每一个点高度的小根堆
    * 因为最边缘的点一定不能存水，所以优先遍历他们，标记为已经遍历过并将它们放入小根堆中
    * 通过BFS算法，通过队列中已经存在的点，遍历其前后左右每一个没有被遍历过的点，
    * 比较原点的高度是否大于当前节点，因为原点一定是边界之中最小的值，那么它前后左右的点只要小于这个值，就一定可以存储水，且存储量为原点高度减去当前点高度
    * 然后将该点压入队列继续比较即可
    * */

    public int trapRainWater(int[][] heights) {

        if (heights == null || heights.length <= 1 || heights[0].length <= 1) {
            return 0;
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        // priority queue store the cell in format of [row, col, height]
        PriorityQueue<int[]> q = new PriorityQueue<>((c1, c2) -> c1[2] - c2[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j, heights[i][j]});
                }
            }
        }
        // bfs from outside
        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, cell[2] - heights[x][y]);
                    q.offer(new int[]{x, y, Math.max(cell[2], heights[x][y])});
                }
            }
        }
        return res;

        // write your code here
    }
}
