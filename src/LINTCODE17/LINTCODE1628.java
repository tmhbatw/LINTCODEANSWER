package LINTCODE17;

public class LINTCODE1628 {
    /*Description
    *有一条路长为L，宽为W，在路中有一些圆形障碍物，半径1，有一辆圆形的车，半径2，问车是否能通过这条路。
    * 你可以把路面当成二维坐标上的一个矩形，四个点为(0,0),(0,W),(L,0),(L,W),现在你需要从x=0出发，
    * 到x=L，不允许与障碍物接触,且车的所有部分都在y=0到y=W之间，不允许接触。
    * */

    public String drivingProblem(int L, int W, double[][] p) {
        // Write your code here.
        boolean top=false,bottom=false;
        for(int i=0;i<p.length;i++){
            double point[]=p[i];
            if(point[1]<=5){
                bottom=true;
            }
            if(point[1]>=W-5){
                top=true;
            }
            if(top&&bottom){
                return "no";
            }
            if(i+1<p.length){
                double point1[]=p[i+1];
                if(Math.pow(point[0]-point1[0],2)+Math.pow(point[1]-point1[1],2)>36){
                    top=false;
                    bottom=false;
                }
            }
        }
        return "yes";
    }
}
