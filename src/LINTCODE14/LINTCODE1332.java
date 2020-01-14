package LINTCODE14;

public class LINTCODE1332 {
    /*Description
    *写一个函数，其以无符号整数为输入，而输出对应二进制数所具有的“1”的位数（也被称为汉明权重）
    * */

    public int hammingWeight(int n) {
        int result=0;
        while(n>0){
            if(n%2==0)
                result++;
            n/=2;
        }
        return result;
        // write your code here
    }

}
