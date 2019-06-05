package LINTCODE2;

public class LINTCODE181 {
    /*Description
    * Determine the number of bits required to flip if you want to convert integer n to integer m.
    * */

    /*Solution
    *取异或判断有多少位为1
    * 或者每一位都进行判断，均可
    * */

    public int bitSwapRequired(int a, int b) {
        a^=b;
        int result=0;
        for(int i=0;i<32;i++){
            result+=(a>>i)&1;
        }
        return result;
        // write your code here
    }

}
