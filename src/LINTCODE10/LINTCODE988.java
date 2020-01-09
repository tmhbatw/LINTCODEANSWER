package LINTCODE10;

public class LINTCODE988 {
    /*Description
    * 你有 n 枚硬币，想要摆放成阶梯形状，即第 k 行恰好有 k 枚硬币。
    * 给出 n，找到可以形成的完整楼梯行数。
    * n 是一个非负整数，且在32位有符号整数范围内。
    * */

    public int arrangeCoins(int n) {
        int result=0;
        int index=1;
        while(n>=index){
            n-=index++;
            result++;
        }
        return result;
        // Write your code here
    }
}
