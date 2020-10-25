package LINTCODE1;

public class LINTCODE21 {
    /*Description
    * 题目将给出两个圆A和B的圆心坐标(x,y)和半径r，现给你一个点P,使圆A圆心沿直线运动至点P。
    * 请问圆A在运动过程中是否会与圆B相交？（运动过程包括起点和终点）
    * 若会相交返回1，否则返回-1。
    * */

    public int IfIntersect(double[] position) {
        double startDistanceA=(position[0]-position[3])*(position[0]-position[3])+(position[1]-position[4])*(position[1]-position[4]);
        double startDistanceB=(position[3]-position[6])*(position[3]-position[6])+(position[4]-position[7])*(position[4]-position[7]);
        double disDiff=(position[2]-position[5])*(position[2]-position[5]);
        double disSum=(position[2]+position[5])*(position[2]+position[5]);
        if(startDistanceA<disDiff&&startDistanceB<disDiff)
            return -1;
        //运动轨迹直线 l 的函数方程
        double A=position[6]-position[0];
        double B=position[1]-position[7];
        double C=-A*position[0]-B*position[1];
        //与l垂直的直线方程
        double A1=B;
        double B1=-A;
        double C1=-A1*position[3]-B1*position[4];
        //交点横坐标
        double denominatorX=A*B1-A1*B;
        double x=denominatorX==0?0:(C1*B-C*B1)/denominatorX;
        if(x<=Math.max(position[0],position[6])&&x>=Math.min(position[0],position[6])) {
            double minDistance = (A * position[3] + B * position[4] + C) * (A * position[3] + B * position[4] + C) / (A * A + B * B);
            return minDistance<=disSum?1:-1;
        }
        return Math.min(startDistanceA,startDistanceB)<=disSum?1:-1;
        //
    }

}
