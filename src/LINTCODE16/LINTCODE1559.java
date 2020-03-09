package LINTCODE16;

public class LINTCODE1559 {
    /*Description
    * 现在你有n个数，保存在arr数组中，你需要选出任意两个数求积，问所有这些可能性的和是多少。返回这个和。返回值对1000000007取模。
    * */

    /*Solution
    * 注意设置result为long后进行转化
    * */

    public int takeTheElementAndQueryTheSum(int[] arr) {
        long sum=0;
        for(int num:arr){
            sum+=num;
        }
        long result=0;
        for(int num:arr){
            sum-=num;
            result+=((sum%1000000007)*(num%1000000007)%1000000007);
        }
        return (int)(result%1000000007);
        // Write your code here
    }
}
