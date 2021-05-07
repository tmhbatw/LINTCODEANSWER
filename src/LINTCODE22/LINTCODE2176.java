package LINTCODE22;

public class LINTCODE2176 {
    /*Description
    * 请编写 Java 语句，求出数组最大值，实现该题的方法有很多种，我们推荐使用 for 循环遍历数组和比较运算符来实现。
    * 本题提供了 Solution 类，Solution 类中有一个 getMax 方法，该方法传递了一个 int[] 类型的参数 array，返回数组中的最大值，且是 int 类型，。
    * 你需要在 // write your code here 下面写出你的代码。
    * */

    public int getMax(int[] array) {
        int max=Integer.MIN_VALUE;
        for(int cur:array){
            max=Math.max(cur,max);
        }
        return max;
        // write your code here
    }
}
