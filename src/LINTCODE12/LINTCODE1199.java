package LINTCODE12;

public class LINTCODE1199 {
    /*Description
    * 我们定义完美数是一个正 整数，它等于除其自身之外的所有 正 约数的总和。
    * 现在，给定一个整数 n，写一个函数，当它是一个完美的数字时返回true，而当它不是时，返回false。
    * */

        public boolean checkPerfectNumber(int num) {
            if(num<0||num==1)
                return false;
            if(num==0)
                return true;
            int res=1;
            int sqr=(int) Math.sqrt(num);
            for(int i=2;i<=sqr;i++){
                if(num%i==0) {
                    res += i;
                    res+=num/i;
                }
            }
            if(sqr*sqr==num)
                res-=Math.sqrt(num);
            return res==num;
            // write your code here
        }
}
