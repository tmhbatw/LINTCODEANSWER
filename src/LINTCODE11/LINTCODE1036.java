package LINTCODE11;

public class LINTCODE1036 {
    /*Description
    * 一次移动是指把(x, y)移动到(x, x + y)或(x + y, y).
    * 给定起点(sx, sy)、目标点(tx, ty)，当且仅当存在一系列移动，
    * 使得从起点开始，能到达终点，则返回True，否则返回False.
    * */

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx>tx||sy>ty)
            return false;
        if(sx==tx){
            return (ty-sy)%sx==0;
        }
        if(sy==ty){
            return (tx-sx)%sy==0;
        }
        if(tx>ty){
            int temp=tx;
            tx=ty;
            ty=temp;
            temp=sy;
            sy=sx;
            sx=temp;
        }
        ty%=tx;
        return reachingPoints(sx,sy,tx,ty);
        // write your code here
    }
}
