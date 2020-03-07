package LINTCODE15;

public class LINTCODE1417 {
    /*Description
    *给出 nn 个金币，每个金币重 10g，但是有一个金币的重量是 11g。现在有一个能够精确称重的天平，问最少称几次，能够确保无论什么情况下均能成功找出那一个重量 11g 的金币？
    * */

    public int minimumtimes(int n) {
        if(n==1)
            return 1;
        if(n%3==0)
            return 1+minimumtimes(n/3);
        return 1+minimumtimes(n/3+1);
        // Write your code here
    }
}
