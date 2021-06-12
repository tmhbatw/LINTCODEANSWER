package LINTCODE8;

public class LINTCODE704 {
    /*Description
    *一个房间中有 n 盏灯最初是开着的，并且墙上有 4 个开关。在对开关进行 m 次未知的操作后，你需要返回这 n 盏灯有多少种不同的状态。
    * 假设 n 盏灯的标号为 [1, 2, 3 ..., n]， 4 个开关的功能如下:
    * 1.将所有灯从开变成关，从关变成开。
    * 2.将标号为偶数的灯从开变成关，从关变成开。
    * 3.将标号为奇数的灯从开变成关，从关变成开。
    * 4.将标号为 (3k + 1) 的灯从开变成关，从关变成开，k = 0, 1, 2...
    * */

    public int flipLights(int n, int m) {
        if (n==0||m==0)
            return 1;
        if(n==1)
            return 2;
        if(m==1){
            if (n == 2) {
                return 3;
            }
            return 4;
        }
        if (m==2) {
            if (n == 2) {
                return 4;
            }
            return 7;
        }
        if (n==2)
            return 4;
        return 8;
        // write your code here
    }
}
