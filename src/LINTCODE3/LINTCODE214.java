package LINTCODE3;

public class LINTCODE214 {
    /*Description
    *给一个浮点数数组，求数组中的最大值。
    * */

    public float maxOfArray(float[] A) {
        float max=A[0];
        for(int i=1;i<A.length;i++){
            max=Math.max(max,A[i]);
        }
        return max;
        // write your code here
    }
}
