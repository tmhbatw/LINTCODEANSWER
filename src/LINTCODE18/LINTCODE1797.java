package LINTCODE18;

public class LINTCODE1797 {
    /*Description
    * 给两个排序的数组。 从两个数组中各取取一个数，这两个数之和需要小于或等于k， 需要找到两数之和最大的索引组合。
    * 返回一对包含两个列表的索引。如果有多个两数之和相等的索引答案，你应该选择第一个数组索引最小的索引对。
    * 1）两数的总和<= k
    * 2）总和是最大的
    * 3）两个数组索引都尽量最小
    * */

    public int[] optimalUtilization(int[] A, int[] B, int K) {
        if(A.length==0||B.length==0||A[0]+B[0]>K)
            return new int[0];
        int[] result=new int[2];
        int k=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]+B[0]>K)
                break;
            if(i>=1&&A[i]==A[i-1])
                continue;
            int left=0,right=B.length-1;
            int curK=K-A[i];
            int mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                if(B[mid]==curK)
                    return new int[]{i,mid};
                if(B[mid]<curK&&(mid==B.length-1||B[mid+1]>curK))
                    break;
                if(B[mid]<curK)
                    left=mid+1;
                else
                    right=mid-1;
            }
            while(mid>=1&&B[mid]==B[mid-1])
                mid--;
            if(A[i]+B[mid]>k){
                result[0]=i;
                result[1]=mid;
                k=A[i]+B[mid];
            }
        }
        return result;
        // write your code here
    }
}
