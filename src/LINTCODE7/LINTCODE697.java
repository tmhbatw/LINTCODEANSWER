package LINTCODE7;

public class LINTCODE697 {
    /*Description
    * 给一个整数 c, 你需要判断是否存在两个整数 a 和 b 使得 a^2 + b^2 = c.
    * */
    public boolean checkSumOfSquareNumbers(int num) {
        if(num<0)
            return false;
        if(num==0)
            return true;
        for(int i=0;i<=Math.sqrt(num);i++){
            int cur=num-i*i;
            int curr= (int) Math.sqrt(cur);
            if(curr*curr==cur)
                return true;
        }
        return false;
        // write your code here
    }
}
