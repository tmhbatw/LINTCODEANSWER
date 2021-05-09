package LINTCODE6;

public class LINTCODE586 {
    /*Description
    * 实现 double sqrt(double x) 并且 x >= 0。
    * 计算并返回x开根后的值。
    * */

    public double sqrt(double x) {
        double l=0,r=Math.max(x,1);
        double end=0.000000000001;
        while(x-l>end){
            double mid=l+(r-l)/2;
            if(mid*mid>x)
                l=mid;
            else
                r=mid;
            System.out.println(l+" "+r);
        }
        return l;
        // write your code here
    }

    public static void main(String[] args){
        double res=0.000000000001;
        System.out.println(res);
    }
}
