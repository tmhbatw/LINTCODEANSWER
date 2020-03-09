package LINTCODE3;

public class LINTCODE236 {
    /*Description
    * 设计一个方法，用尽可能少的指令，将一个整数中奇数数位和偶数数位的数字交换
    * （如，数位 0 和数位 1 交换，数位 2 和数位 3 交换，等等）。
    * */

    public int swapOddEvenBits(int x) {
        int result=0;
        int time=1;
        while(x>0){
            int cur=x%4;
            if(cur==3)
                result+=3*time;
            if(cur==2)
                result+=time;
            if(cur==1)
                result+=time*2;
            time*=4;
        }
        return result;
        // write your code here
    }
}
