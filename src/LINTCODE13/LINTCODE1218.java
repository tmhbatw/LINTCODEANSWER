package LINTCODE13;

public class LINTCODE1218 {
    /*Description
    * 给定一个正整数，输出它的补数。补数是将原先数字的二进制表示按位取反，再换回十进制后得到的新数。
    * */

    public int findComplement(int num) {
        if(num==Integer.MAX_VALUE)
            return 0;

        int wei=0;
        int temp=num;
        while(num>0){
            wei++;
            num/=2;
        }
        return (int)(Math.pow(2,wei)-1-temp);
        // Write your code here
    }
}
