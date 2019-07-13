package LINTCODE6;

public class LINTCODE518 {

    /*Description
    * 写一个程序来找第 n 个超级丑数。
    * 超级丑数是所有的质数因子都在给定的的质数集合内的正整数。
    * 比如给定质数集合 [2, 7, 13, 19], 那么 [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] 是前 12 个超级丑数。
    * */

    /*Solution
    * 保存由当前质数得出的下一个质数，比较大小输出到结果数组中
    * 如果遇到数字相等的情况，那么均寻找下一个数
    * */

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result=new int[n];
        result[0]=1;
        int[] index=new int[primes.length];
        int[] curr=primes.clone();
        for(int i=1;i<n;i++){
            getCurrmin(curr,primes,index,result,i);
        }
        return result[n-1];
        // write your code here
    }

    public void getCurrmin(int[]curr,int[] primes,int[] indexx,int[] result,int n){
        int index=0;
        int min=curr[0];
        for(int i=1;i<curr.length;i++){
            if(curr[i]<min){
                min=curr[i];
                index=i;
            }else if(curr[i]==min){
                curr[i]=primes[i]*result[++indexx[i]];
            }
        }
        result[n]=min;
        curr[index]=primes[index]*result[++indexx[index]];
    }


}
