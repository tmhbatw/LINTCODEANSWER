package LINTCODE12;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LINTCODE1149 {
    /*Description
    * 给定2D空间中四个点的坐标，返回四个点是否可以构造一个正方形。
    * 点的坐标（x，y）由具有两个整数的整数数组表示。
    * */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] distance=new int[6];
        distance[0]=getDistance(p1,p2);
        distance[1]=getDistance(p1,p3);
        distance[2]=getDistance(p1,p4);
        distance[3]=getDistance(p2,p3);
        distance[4]=getDistance(p2,p4);
        distance[5]=getDistance(p3,p4);
        Arrays.sort(distance);
        if(distance[0]==distance[1]&&distance[0]==distance[2]&&distance[0]==distance[3]&&distance[5]==distance[4]&&distance[5]==distance[0]*2)
            return true;
        return false;
        // Write your code here
    }

    private int getDistance(int[] p1,int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }

}
