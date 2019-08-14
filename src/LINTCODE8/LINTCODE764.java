package LINTCODE8;

public class LINTCODE764 {
    /*Description
    *给定半径r，返回圆的周长nums[0]和面积nums[1].结果保留了两位小数.
    * */

    public double[] calculate(int r) {
        double pai=3.14;
        return new double[]{2*r*pai,r*r*pai};
        // write your code here
    }
}
