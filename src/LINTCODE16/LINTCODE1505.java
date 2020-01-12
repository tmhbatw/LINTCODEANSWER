package LINTCODE16;

public class LINTCODE1505 {
    /*Description
    * 找数字
    * */

    public boolean findnNumber(int[] nums, int k) {
        for(int cur:nums)
            if(k==cur)
                return true;
            return false;
        // write your code here
    }
}
