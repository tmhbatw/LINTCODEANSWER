package LINTCODE10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE912 {
    /*Description
    * 有一群住在不同地方的朋友（两个或以上）想要在某地见面，要求他们去往目的地的路程和最短。
    * 现在给一个0、1组成的二维数组，1表示此地有一个人居住。使用曼哈顿距离作为计算总距离，
    * 公式为：(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|
    * */

    public int minTotalDistance(int[][] grid) {
        List<Integer> row=new ArrayList<>();
        List<Integer> col=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Collections.sort(col);
        int midRow = row.size()%2==0?(row.get(row.size()/2)+row.get(row.size()/2-1))/2:row.get(row.size()/2);
        int midCol = col.size()%2==0?(col.get(col.size()/2)+col.get(col.size()/2-1))/2:col.get(col.size()/2);
        int res=0;
        for(int cur:row){
            res+=Math.abs(cur-midRow);
        }
        for(int cur:col){
            res+=Math.abs(cur-midCol);
        }
        return res;
        // Write your code here
    }
}
