package LINTCODE2;

public class LINTCODE142 {
    /*Description
    *Using O(1) time to check whether an integer n is a power of 2.
    * */

    /*Solution
    * 2的幂次方的数字二进制32位只有1位为1且不是第一位
    * 按位运算统计出现的1的次数是否为1即可
    * */
    public boolean checkPowerOf2(int n) {
        int count=0;
        for(int i=0;i<31;i++){
            if((n>>i&1)==1)
                count++;
        }
        return count==1;
        // write your code here
    }
}
