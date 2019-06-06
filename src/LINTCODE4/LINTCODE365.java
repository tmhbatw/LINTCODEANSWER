package LINTCODE4;

public class LINTCODE365 {
    /*Description
    * 计算在一个 32 位的整数的二进制表示中有多少个 1。
    * Challenge
    * 如果整数有 n 位，并且有 m 位个 1。你能在 O(m) 的时间内解决它吗？
    * */

    /*Solution
    * 当然可以右移判断是否为1，可是复杂度为O(32)
    * 另一种巧妙的办法：一个整数与它的值减一进行与操作，可以消去最右边的1，判断可以进行几次与操作即可(然而消耗时间更多）
    * */



    public int countOnes(int num) {
        int result=0;
        for(int i=0;i<32;i++){
            num>>=1;
            result+=num&1;
        }
        return result;
        // write your code here
    }

/*    public int countOnes(int num) {
        int result=0;
        while(num!=0){
            num&=(num-1);
            result++;
        }
        return result;
        // write your code here
    }*/
}
