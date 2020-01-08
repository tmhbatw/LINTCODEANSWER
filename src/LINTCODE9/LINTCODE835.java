package LINTCODE9;

public class LINTCODE835 {
    /*Description
    * Hamming距离
    * 两个整数的Hamming距离是对应比特位不同的个数。
    * 给定两个整数x和y，计算两者的Hamming距离。
    * */

    /*Solution
    * 按位运算即可
    * */

    public int hammingDistance(int x, int y) {
        int res=0;
        int temp=x^y;
        while(temp>0){
            res+=(temp&1)==0?0:1;
            temp>>=1;
        }
        return res;
        // write your code here
    }
}
