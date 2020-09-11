package LINTCODE9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE853 {
    /*Description
    * 给定一个只含0和1的网格，寻找有多少个转角矩形。
    * 注意，只有转角处需要为1，并且这四个1的位置互不相同。
    * */

    public int countCornerRectangles(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] res=new int[row][col];
        for(int[] cur:grid){
            List<Integer> set=new ArrayList<>();
            for(int i=0;i<col;i++){
                if(cur[i]==1)
                    set.add(i);
            }
            for(int i=0;i<set.size();i++){
                int curr=set.get(i);
                for(int j=i+1;j<set.size();j++)
                    res[curr][set.get(j)]++;
            }
        }
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                result+=res[i][j]*(res[i][j]-1)/2;
            }
        }
        return result;
        // Write your code here
    }
}
