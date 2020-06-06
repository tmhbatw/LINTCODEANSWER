package LINTCODE16;

public class LINTCODE1503 {
    /*Description
    * 某国的货币系统包含面值 1 元、4 元、16 元、64元共 4 种硬币，以及面值 1024 元的纸币。
    * 你现在使用 1024 元的纸币购买了一件价值为 N, 0 < N <= 1024N,0<N<=1024 元的商品，请问最少会收到多少个硬币作为找零。
    * */


    public int giveChange(int amount) {
        amount=1024-amount;
        int result=0;
        result+=amount/64;
        amount%=64;
        result+=amount/16;
        amount%=16;
        result+=amount/4;
        amount%=4;
        result+=amount;
        return result;
        // write you code here.
    }
}
