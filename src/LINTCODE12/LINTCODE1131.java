package LINTCODE12;

public class LINTCODE1131 {
    /*Description
    *
    * */

    public int[] minMax(int n) {
        int[] min=new int[]{1,1,0,0};
        return new int[]{min[(n-1)%4],n-min[(n-2)%4]};
        // write your code here.
    }
}
