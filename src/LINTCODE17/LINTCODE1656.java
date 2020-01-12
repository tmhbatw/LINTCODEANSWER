package LINTCODE17;

public class LINTCODE1656 {
    /*Description
    *给定n个整数和两个正整数L,R，输出有多少个数的数值范围在[L, R]之间
    * */

    public int getNum(int[] a, int L, int R) {
        int res=0;
        for(int cur:a){
            if(cur<=R&&cur>=L)
                res++;
        }
        return res;
        // Write your code here
    }
}
