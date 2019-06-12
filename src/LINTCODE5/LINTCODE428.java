package LINTCODE5;

public class LINTCODE428 {

    /*Description
    * 实现 pow(x, n). (n是一个整数)
    * */

    /*Solution
    * 将x进行左移可以简化实现过程
    * 需要注意的是对Integer.MIN_VALUE的处理
    * */

    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0){
            x=1/x;
            n=-n;
        }
        int[] nums=new int[32];
        for(int i=0;i<32;i++){
            if(n>(1<<(31-i))){
                nums[i]=1;
                n=n-(1<<(31-i));
            }
        }
        double result=1.0;
        double xx=x;
        for(int i=31;i>=0;i--){
            if(nums[i]==1)
                result*=xx;
            xx*=x;
        }
        return result;
        // write your code here
    }

}
