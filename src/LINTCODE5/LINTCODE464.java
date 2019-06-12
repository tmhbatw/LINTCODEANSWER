package LINTCODE5;

public class LINTCODE464 {

    /*Description
    * 给一组整数，请将其在原地按照升序排序。使用归并排序，快速排序，堆排序或者任何其他 O(n log n) 的排序算法。
    * */

    /*Solution
    * 快速排序即可
    * */

    public void sortIntegers2(int[] A) {
        if(A.length==0)
            return;
        recursion(A,0,A.length);
        // write your code here
    }

    private void recursion(int[] A,int start,int end){
        if(start<=end)
            return;
        if(end-start==1){
            if(A[start]<A[end]){
                int temp=A[start];
                A[start]=A[end];
                A[end]=A[start];
            }
        }
        int i=start,j=end;
        while(i<j){
            if(A[j]>A[start]){
                j--;
                continue;
            }
            if(A[i]<=A[start]){
                i++;
                continue;
            }
            int temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
        int temp=A[start];
        A[start]=A[i];
        A[i]=A[start];
        recursion(A,start,i-1);
        recursion(A,i+1,end);
    }
}
