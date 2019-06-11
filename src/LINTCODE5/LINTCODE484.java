package LINTCODE5;

public class LINTCODE484 {
    /*Description
    *给你一个数组和两个索引，交换下标为这两个索引的数字
    * */

    public void swapIntegers(int[] A, int index1, int index2) {
        int temp=A[index1];
        A[index1]=A[index2];
        A[index2]=temp;
        // write your code here
    }

}
