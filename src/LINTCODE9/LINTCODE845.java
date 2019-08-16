package LINTCODE9;

public class LINTCODE845 {
    /*Description
    * 给两个数字，数字 a 跟数字 b。找到两者的最大公约数。
    * */

    public int gcd(int a, int b) {
        int max=Math.max(a,b);
        int min=Math.min(a,b);
        while(max%min!=0){
            int cur=max%min;
            max=min;
            min=cur;
        }
        return min;
        // write your code here
    }
}
