package LINTCODE13;

public class LINTCODE1275 {
    /*Description
    *你的任务是计算 a^b mod 1337，其中 a 是一个正整数，b 是一个超级大的正整数，以数组的形式给出。
    * */

    public int superPow(int a, int[] b) {
        int mod=1337;
        a%=mod;
        int curRes=1;
        for(int i=b.length-1;i>=0;i--){
            int cur=b[i];
            while(cur-->0){
                curRes*=a;
                curRes%=mod;
            }
            int index=10;
            int aa=a;
            while(--index>0){
                aa*=a;
                aa%=mod;
            }
            a=aa;
        }
        return curRes;
        // Write your code here
    }
}
