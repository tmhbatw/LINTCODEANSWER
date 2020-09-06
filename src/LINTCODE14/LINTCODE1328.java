package LINTCODE14;

public class LINTCODE1328 {
    /*Description
    * 给定数字 AA 和 BB 以及系数 pp 和 qq 。
    * 每次操作可以将 AA 变成 AA + pp 或者将 pp 变成 pp * qq。
    * 返回最少变化次数使得 BB <= AA
    * */

    public int DoubleChange(int A, int B, int p, int q) {
        if(A>=B)
            return 0;
        int diff=B-A;
        int result=1;
        long pp=p;
        while(pp<diff){
            pp*=q;
            result++;
        }
        return result;
        // write your code here
    }
}
