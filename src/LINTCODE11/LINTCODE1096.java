package LINTCODE11;

public class LINTCODE1096 {
    /*Description
    * 最大公倍数
    * 小栖有一个区间[a,b][a,b]，他准备从中取三个数，他想知道如何取才能使得它们的最小公倍数最大
    * 请直接告诉小栖最小公倍数是多少
    * */

    public long greatestcommonmultiple(int a, int b) {
        long result=1;
        if(b%2!=0)
            result*=b*(b-1)*(b-2);
        else{
            result*=(b-1)*(b-3);
            if(b%3==0)
                result*=(b-2);
            result*=b;
        }
        return result;
        // write your code here
    }


}
