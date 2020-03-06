package LINTCODE9;

import datastructure.Point;

public class LINTCODE844 {
    /*Description
    * 给一个<Point>的List p，求满足p[i].x+p[j].x和p[i].y+p[j].y（i < j)都能被2整除的(i,j)对数。
    * */

    public int pairNumbers(Point[] p) {
        int[][] type=new int[2][2];
        for(Point cur:p){
            int x=cur.x;
            int y=cur.y;
            type[x%2][y%2]++;
        }
        return getResult(type[0][0])+getResult(type[0][1])+getResult(type[1][1])+getResult(type[1][0]);
        // Write your code here
    }

    private int getResult(int cur){
        return cur*(cur-1)/2;
    }
}
