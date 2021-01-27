package LINTCODE3;

public class LINTCODE220 {
    /*Description
    * 数学家们曾提出一个著名的猜想——冰雹猜想。
    * 对于任意一个自然数N，如果N是偶数，就把它变成N / 2；
    * 如果N是奇数，就把它变成 3 * N+1。
    * 按照这个法则运算下去，最终必然得1。
    * 试问，该数通过几轮变换，会变成1呢？
    * */

    public int getAnswer(int num) {
        if(num==1)
            return 0;
        return 1+(num%2==0?getAnswer(num/2):getAnswer(num*3+1));
        // write your code here.
    }
}
