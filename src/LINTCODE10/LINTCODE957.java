package LINTCODE10;

import datastructure.Point;

public class LINTCODE957 {
    /*Description
    * 一个2D平面上有一堆雷达（雷达有x, y坐标，以及能探测到的范围r半径）。
    * 现在有一辆小车要从y = 0和y = 1的区间里面通过并且不能被雷达探测到。若被检测到，输出YES，否则输出NO。
    * （可以认为，小车是一条长度为1的线段，沿直线从x = 0 向右前进）
    * */

    public String radarDetection(Point[] coordinates, int[] radius) {
        for(int i=0;i<coordinates.length;i++){
            Point cur=coordinates[i];
            if(cur.y==0)
                return "YES";
            int curRadius=radius[i];
            if(cur.y>0&&cur.y-curRadius<=0)
                return "YES";
            if(cur.y<0&&cur.y+curRadius>=0)
                return "YES";
        }
        return "False";
        // Write your code here
    }
}
