package LINTCODE2;

public class LINTCODE144 {
    /*Description
    * Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
    * */

    /*Solution
    * 首先遍历一遍数组以判断排序后开始位置的数组是正数还是负数
    * 创建两个下标分别表示奇数位与偶数位，当奇数位或偶数位满足要求则继续向后遍历
    * 如果找到均不满足的两位置则进行交换
    * */
    public void rerange(int[] A) {
        if(A.length<=2)
            return;
        int pos=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>0)
                pos++;
            else{pos--;}
        }
        if(pos>=0) {
            //正负正负正
            int i = 0, n = 1;
            while (i < A.length &&n<A.length) {
                if (A[i] > 0) {
                    i += 2;
                    continue;
                }
                if (A[n] < 0) {
                    n+=2;
                    continue;
                }
                int temp=A[i];
                A[i]=A[n];
                A[n]=temp;
                i+=2;
                n+=2;
            }
        }else{
            //负正负正负
            int i=0,n=1;
            while(i<A.length&&n<A.length){
                if(A[i]<0){
                    i+=2;
                    continue;
                }
                if(A[n]>0){
                    n+=2;
                    continue;
                }
                int temp=A[i];
                A[i]=A[n];
                A[n]=temp;
                i+=2;
                n+=2;
            }

        }
    }
}
