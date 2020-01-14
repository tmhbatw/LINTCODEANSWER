package LINTCODE11;

public class LINTCODE1005 {
    /*Description
    * 平面上有一系列点。返回由其中三个点可以形成的三角形最大面积。
    * */

    /*Solution
    * 注意三角形面积公式为：S=(x1y2-x1y3+x2y3-x2y1+x3y1-x2y2)
    * */

    public double largestTriangleArea(int[][] points) {
        double result=Double.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=j+1;k<points.length;k++){
                    result=Math.max(result,getArea(points[i],points[j],points[k]));
                }
            }
        }
        return result;
        // write your code here
    }

    private double getArea(int[] x,int[] y,int[] z ){
        return Math.abs(0.5*(x[0]*y[1]+y[0]*z[1]+z[0]*x[1]-x[0]*z[1]-y[0]*x[1]-z[0]*y[1]));
    }
}
