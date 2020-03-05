package LINTCODE10;

public class LINTCODE952 {
    /*Description
    *给一个转换规则来转换数字n：
    * n是奇数，n = 3n + 1
    * n是偶数，n = n / 2
    * 经过若干次转换后，n会变成1。
    * 现在给一个n，输出它转换到1需要的次数。
    * */

    public int digitConvert(int n) {
        int result=0;
        long cur=n;
        while(cur!=1){
            cur=change(cur);
            result++;
        }
        return result;
        // Write your code here
    }

    private long change(long cur){
        if(cur%2==0)
            return cur/2;
        return cur*3+1;
    }
}
