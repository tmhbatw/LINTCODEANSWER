package LINTCODE2;

public class LINTCODE179 {
    /*Description
    *给出两个32位的整数N和M，以及两个二进制位的位置i和j。写一个方法来使得N中的第i到j位等于M（M会是N中从第i为开始到第j位的子串）
    * */

    /*Solution
    *首先生成从i到j位全都是0，其他位置都是1的数，将它与n取余,然后加上m左移i位的值即可
    * 注意：按位运算符优先级较低，一定注意括号的使用
    * */
    public int updateBits(int n, int m, int i, int j) {

        int a=j<31?~((1 << (j+1)) - (1 << i)  ):(1<<i)-1;
        System.out.println(Integer.toBinaryString(a));
        return m<<i+n&a;
        // write your code here
    }
}
