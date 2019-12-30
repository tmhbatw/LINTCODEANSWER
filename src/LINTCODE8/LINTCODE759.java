package LINTCODE8;

public class LINTCODE759 {
    /*Description
    * 计算在时钟中以 h:m 时刻的时针和分针之间的角度。
    * */

    /*Solution
    * 注意分钟的变动会影响时针
    * */

    public float timeAngle(int h, int m) {
        h=h%12;
        float degreeH= (float) (h*30+m*0.5);
        float degreeM=m*6;
        float result=Math.abs(degreeH-degreeM);
        return result>=180?360-result:result;
        // write your code here
    }

}
