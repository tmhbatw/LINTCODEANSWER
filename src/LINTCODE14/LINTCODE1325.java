package LINTCODE14;

public class LINTCODE1325 {
    /*Description
    * 给定范围[m，n]，其中0 <= m <= n <= 2147483647，输出此范围内所有数字的按位AND，包括端值。
    * 例如，给定范围[5,7]，输出返回4。
    * */

    public int rangeBitwiseAnd(int m, int n) {
        int moveTime=0;
        while(m!=n){
            moveTime++;
            m>>=1;
            n>>=1;
        }
        return m<<moveTime;
        // Write your code here
    }
}
