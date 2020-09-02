package LINTCODE4;

public class LINTCODE309 {

    /*Description
    * 给定两个相同长度的数组，通过取第一个数组的第一个元素，第二个数组的第一个元素，第一个数组的第二个元素...依此类推来交叉它们。返回新的交错数组。
    * 注意 ： 长度 ≤ 10000
    * */

    public int[] interleavedArray(int[] A, int[] B) {
        int[] result=new int[A.length*2];
        for(int i=0;i<A.length;i++){
            result[i*2]=A[i];
            result[i*2+1]=B[i];
        }
        return result;
        // Interleaved Array
    }
}
