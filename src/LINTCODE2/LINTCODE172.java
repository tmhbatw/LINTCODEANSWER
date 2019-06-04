package LINTCODE2;

public class LINTCODE172 {

    /*Description
    * Given an array and a value, remove all occurrences of that value in place and return the new length.
    * The order of elements can be changed, and the elements after the new length don't matter.
    * */

    /*Solution
    * 双指针方法
    * */

    public int removeElement(int[] A, int elem) {
        int i=0;
        for(int j=0;j<A.length;j++){
            if(A[j]!=elem)
                A[i++]=A[j];
        }
        return i;
        // write your code here
    }
}
