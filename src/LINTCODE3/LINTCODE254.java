package LINTCODE3;

public class LINTCODE254 {
    /*Description
    * 楼有 n 层高，鸡蛋若从 k 层或以上扔，就会碎。从 k 层以下扔，就不会碎。
    * 现在给两个鸡蛋，用最少的扔的次数找到 k。返回最坏情况下次数。
    * */

    public int dropEggs(int n) {
        // Write your code here
        long ans = 0;
        int index=1;
        while(true){
            ans+=(long)index;
            if(ans>=(long)n)
                return index;
            index++;

        }
    }
}
