package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1802 {
    /*Description
    * 给定一个具有n行和m列二进制整数的矩阵包含0或1，以及一组规则和模拟该矩阵上的游戏轮次k。给定的矩阵表示游戏的初始配置，
    * 其中grid [i] [ j] = 1表示第i行和第j列中的单元是活动的，并且grid [i] [j] = 0表示该单元已死。
    * 当两个点共享至少一个公共角时，它们是邻居，每个位置最多有8个邻居，如下图所示：
    * 有一个从0到8索引的9条规则的列表，每条规则的值都是“alive”或“dead”。单个规则 rules[i]，指定刚好有i个活着邻居的单元格会发生什么。
    * 转动单元格的新值是通过计算“活着”邻居的数量并在与计数对应的索引处应用规则来确定的。 与规则对应的值用于在单元格中设置新值
    * 第一轮的“每个节点活着的邻居”矩阵包含初始每个矩阵位置处的相邻的活着节点的数量。它用于为第1轮创建新的矩阵状态。在每个节点具有值3或5 ，
    * 新网格中的相关单元格设置为活着。 所有其他的都被设置为死亡即为0。对于第二个回合，类似地分析所得到的网格。 返回的二维数组展示第二轮所示的矩阵。
    * */

    public int[][] GridGame(int[][] grid, String[] rules, int k) {
        boolean[] rule=change(rules);
        for(int i=0;i<k;i++){
            grid=getNeighborNumber(grid,rule);
        }
        return grid;
        // write your code here
    }

    private int[][] getNeighborNumber(int[][] grid,boolean[] rule){
        int m=grid.length;
        int n=grid[0].length;
        int[][] result=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cur=0;
                cur+=i>=1&&j>=1?grid[i-1][j-1]:0;
                cur+=i>=1?grid[i-1][j]:0;
                cur+=i>=1&&j<n-1?grid[i-1][j+1]:0;
                cur+=j>=1?grid[i][j-1]:0;
                cur+=j<n-1?grid[i][j+1]:0;
                cur+=i<m-1&&j>=1?grid[i+1][j-1]:0;
                cur+=i<m-1?grid[i+1][j]:0;
                cur+=i<m-1&&j<n-1?grid[i+1][j+1]:0;
                if(rule[cur])
                    result[i][j]=1;
            }
        }
        grid=null;
        return result;
    }

    private boolean[] change(String[] rules){
        boolean[] rule=new boolean[9];
        for(int i=0;i<9;i++){
            if(rules[i].equals("alive"))
                rule[i]=true;
        }
        return rule;
    }
}
