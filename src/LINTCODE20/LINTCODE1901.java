package LINTCODE20;

public class LINTCODE1901 {
    /*Description
    * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    * */

    public int[] SquareArray(int[] A) {
        int length=A.length;
        int[] result=new int[length];
        int right=0;
        for(int i=0;i<length;i++){
            if(A[i]>0){
                right=i;
                break;
            }
        }
        int left=right-1;
        int index=0;
        while(index<length){
            int r=right<length?A[right]*A[right]:Integer.MAX_VALUE;
            int l=left>=0?A[left]*A[left]:Integer.MAX_VALUE;
            if(r<l){
                result[index++]=r;
                right++;
            }else{
                result[index++]=l;
                left--;
            }
        }
        return result;
        //
    }
}
