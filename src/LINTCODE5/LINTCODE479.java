package LINTCODE5;

public class LINTCODE479 {
    /*Description
    *Find the second max number in a given array.
    * */

    /*Solution
    *记录最大值和最小值即可
    * */

    public int secondMax(int[] nums) {
        int first=Integer.MIN_VALUE+1;
        int second=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>first){
                second=first;
                first=num;
            }else if(num>second){
                second=num;
            }
        }
        return second;
        // write your code here
    }
}
