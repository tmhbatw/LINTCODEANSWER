package LINTCODE14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1326 {
    /*Description
    * 给定一个n * n 的矩阵，按照矩阵的层次顺时针排序，返回按层排好序的矩阵
    * */

    public int[][] BoarderSort(int[][] grids) {
        int length=grids.length;
        for(int i=0;i<length/2;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=i;j<length-1-i;j++){
                list.add(grids[i][j]);
                list.add(grids[length-i-1][length-j-1]);
                list.add(grids[j][length-i-1]);
                list.add(grids[length-j-1][i]);
            }
            Collections.sort(list);
            int index=0;
            for(int j=i;j<length-i-1;j++)
                grids[i][j]=list.get(index++);
            for(int j=i;j<length-i-1;j++)
                grids[j][length-i-1]=list.get(index++);
            for(int j=i;j<length-i-1;j++)
                grids[length-i-1][length-j-1]=list.get(index++);
            for(int j=i;j<length-i-1;j++)
                grids[length-j-1][i]=list.get(index++);
            System.out.println(list);
        }
        return grids;
        // write your code here
    }
}
