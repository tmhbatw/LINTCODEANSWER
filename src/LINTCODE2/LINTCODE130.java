package LINTCODE2;

public class LINTCODE130 {
    /*Description
    *Given an integer array, heapify it into a min-heap array.
    * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
    * */

    /*Solution
    *将第i个数字与第2*i+1与2*i+2比较
    * 若第i个数字比较大则进行第i+1个数字的比较
    * 如果i小于其中较小的数字，将数字交换位置后，递归进行交换位置的比较直到满足要求
    * 注意要考虑当前交换后对后面数字的影响情况
    * */


    public void heapify(int[] A) {
        for(int i=A.length/2;i>=0;i--)
            recursion(A,i);
        // write your code here
    }

    private void recursion(int[] A,int index){
        int min=A[index];
        int minpos=index;
        if(index*2+1<A.length&&A[index*2+1]<min) {
            minpos=index*2+1;
            min = A[minpos];
        }
        if(index*2+2<A.length&&A[index*2+2]<min){
            minpos=index*2+2;
            min=A[minpos];
        }
        if(minpos!=index){
            int temp=A[index];
            A[index]=A[minpos];
            A[minpos]=temp;
            recursion(A,minpos);
        }
    }
}
