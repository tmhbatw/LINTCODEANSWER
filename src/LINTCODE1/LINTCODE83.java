package LINTCODE1;

public class LINTCODE83 {
    /*Description
    *Given 3*n + 1 non-negative integer, every numbers occurs triple times except one, find it.
    * */

    /*Solution
    * 用一个32位数组表示一个Integer的每一位
    * 当某个数出现3次时，某一位必然出现3次，因此每当某一位数组变为3时，清0
    * 数组中剩下的最后的数即表示唯一出现一次的数
    * */

    public int singleNumberII(int[] A) {
        // write your code here
        int[] count=new int[32];
        int result=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<32;j++){
                count[j]+=(A[i]>>j&1);
/*                if(count[j]==3){
                    count[j]=0;
                }*/
            }
        }
        for(int i=0;i<32;i++){
            count[i]=count[i]%3;
            result=result|(count[i]<<i);
        }
        return result;
    }
}
