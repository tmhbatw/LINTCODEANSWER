package LINTCODE9;

public class LINTCODE886 {

    /*Description
    * 给定一组点的数组，当一个多边形按顺序连接时，发现这个多边形是凸多边形(凸多边形定义)。
    * */

    public boolean isConvex(int[][] point) {
        boolean flag1=false;
        boolean flag2=false;
        int length=point.length;
        for(int i=0;i<point.length;i++){
            int i1=i,i2=(i+1)%length,i3=(i+2)%length;
            int val=getVal(point[i1],point[i2],point[i3]);
            if(val>0)
                flag1=true;
            if(val<0)
                flag2=true;
        }
        return flag1^flag2;
        // write your code here
    }

    private int getVal(int[] cur1,int[] cur2,int[] cur3) {
        int x1 = cur2[0] - cur1[0];
        int y1 = cur2[1] - cur1[1];
        int x2 = cur3[0] - cur2[0];
        int y2 = cur3[1] - cur2[1];
        return x1 * y2 - y1 * x2;
    }
}
