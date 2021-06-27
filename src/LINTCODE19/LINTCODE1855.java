package LINTCODE19;

public class LINTCODE1855 {
    /*Description
    * 给定一个起点 (sx, sy) 和一个终点 (dx, dy)，如果通过一系列的转换可以将起点转换成终点，
    * 则返回 True ，否则返回 False。转换规则为：从点 (x, y)
    * 可以转换到 (x, x+y)  或者 (x+y, y)。
    * */

    public boolean reachDestination(int sx, int sy, int dx, int dy) {
        if(dx<sx||dy<sy)
            return false;
        if(dx==sx)
            return (dy - sy) % dx == 0;
        if(dy==sy)
            return (dx-sx)%sy==0;
        if(dy>dx)
            return reachDestination(sx,sy,dx,dy%dx);
        return reachDestination(sx,sy,dx%dy,dy);
        // Write your code here.
    }
}
