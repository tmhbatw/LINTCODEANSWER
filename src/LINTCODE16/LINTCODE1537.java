package LINTCODE16;

public class LINTCODE1537 {

    /*Description
    *给定一个只包含0，1两个元素的数组，只能交换相邻的元素使这个数组升序
    * (即所有的0都在1的左边)，返回最少交换次数。
    * */


    public int SwapZeroOne(int[] nums) {
        int result=0;
        int countOne=0;
        for(int cur:nums){
            if(cur==0)
                result+=countOne;
            if(cur==1)
                countOne++;
        }
        return result;
        // Write your code here
    }
}
