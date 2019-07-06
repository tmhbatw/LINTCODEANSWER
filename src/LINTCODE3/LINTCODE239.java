package LINTCODE3;

public class LINTCODE239 {
    /*Description
    * 给一个方程：ax2 + bx + c = 0，求根。
    * */

    /*Solution
    * 求根公式
    * 需要注意较小的结果应该排在前面
    * */

    public double[] rootOfEquation(double a, double b, double c) {
        double judge=b*b-4*a*c;
        if(judge<0)
            return new double[0];
        if(judge==0){
            return new double[]{-b/2/a};
        }
        double res1=(-b+Math.sqrt(judge))/2/a;
        double res2=(-b-Math.sqrt(judge))/2/a;
        if(res1<res2){
            return new double[]{res1,res2};
        }
        return new double[]{res2,res1};
        // write your code here
    }
}
