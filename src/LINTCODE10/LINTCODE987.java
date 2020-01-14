package LINTCODE10;

public class LINTCODE987 {
    /*Description
    * 给一个正整数，检查它的二进制表示是否具有交替位：即，两个相邻的位总是具有不同的值。
    * */

    public boolean hasAlternatingBits(int n) {
        boolean isOne=n%2==1;
        while(n>0){
            n/=2;
            if(!isOne^n%2==1)
                return false;
            isOne=!isOne;
        }
        return true;
    }
}
