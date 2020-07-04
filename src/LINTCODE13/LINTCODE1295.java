package LINTCODE13;

public class LINTCODE1295 {
    /*Description
    * 题目给定一个正整数N，你需要统计(1,N]之间所有整数质数分解后，所有质数的总个数。
    * */

    public int Count_PrimeNum(int N) {
        int[] count=new int[N+1];
        count[2]=1;
        for(int i=3;i<=N;i++){
            int cur=getFirstPrime(i);
            if(getFirstPrime(i)==-1)
                count[i]=1;
            else
                count[i]=1+count[i/cur];
        }
        int result=0;
        for(int i=2;i<=N;i++)
            result+=count[i];
        return result;
        //
    }

    private int getFirstPrime(int cur){
        if(cur%2==0)
            return 2;
        for(int i=3;i<=(int)Math.sqrt(cur);i+=2){
            if(cur%i==0)
                return i;
        }
        return -1;
    }
}
