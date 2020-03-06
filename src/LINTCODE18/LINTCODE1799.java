package LINTCODE18;

public class LINTCODE1799 {
    /*Description
    * 小明在上数学课，课上老师说需要求等差为1的等差数列的和，这个很简单。
    * 但是小明想到，如果在某一刻，等差变为了-1，再进行求和怎么解？
    * 你能帮帮他嘛？
    * 例子：首项为5，在第5项也就是9的时候等差变为了-1，末项为6，那么这个数列的和是5+6+7+8+9+8+7+6=56
    * 输入：首项的值i，在第j项的时候等差变为了-1，末项的值k
    * 输出：数列的和
    * */

    public long equlSum(long i, long j, long k) {
        if(i==j&&j==k)
            return i;
        long time1=j-i+1;
        long time2=j-k+1;
        return (i+j)*time1/2+(j+k)*time2/2-j;
        // Write your code here
    }
}
