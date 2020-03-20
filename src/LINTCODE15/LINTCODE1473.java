package LINTCODE15;

public class LINTCODE1473 {
    /*Description
    * 给定一个数组arr，分别对他的每个子数组求和，再把所有的和加起来，返回这个值。返回值对1000000007取模。
    * */

    public long findTheSumOfTheArray(int[] arr) {
        int mod=1000000007;
        long result=0;
        long pre=0,last=arr.length+1;
        for(int cur:arr){
            pre++;
            last--;
            result+=pre*last*cur%mod;
        }
        return result%mod;
        // Write your code here
    }

    public static void main(String[] args){

    }


}
