package LINTCODE;

public class LINTCODE6 {
    /*
    Description
    *Merge two given sorted ascending integer array A and B into a new sorted integer array.
    * */

    /*
    *Solution
    *用a,b两个值表示数组A、B的下标，比较A[a]、B[b]的大小并插入结果数组中
    * 下为超越99.8%解法
    * */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] result=new int[A.length+B.length];
        int a=0,b=0;//分别表示数组A、B的下标
        for(int i=0;i<result.length;++i){
            if(a==A.length){
                result[i]=B[b];
                b++;
                continue;
            }
            if(b==B.length){
                result[i]=A[a];
                a++;
                continue;
            }
            result[i]=Math.min(A[a],B[b]);
            if(A[a]<B[b]){
                a++;
            }else{
                b++;
            }
        }
        return result;
    }
}
