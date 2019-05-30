package LINTCODE1;

public class LINTCODE63 {
    /*Description
    *跟进“搜索旋转排序数组”，假如有重复元素又将如何？
    * 是否会影响运行时间复杂度？
    * 如何影响？
    * 为何会影响？
    * 写出一个函数判断给定的目标值是否出现在数组中。
    * */

    /*Solution
    * 当第一个数与最后一个数相等时，会出现无法正常判断rorateIndex的情况
    * 可以将前面所有与最后一个数相等的数加1
    * 时间复杂度最差情况为O(n)
    * */

    public boolean search(int[] A, int target) {
        if(A.length==0)
            return false;
        if(A[0]==target)
            return true;
        int rorateIndex=0;
        int left=0,right=A.length-1;
        for(int i=A.length-1;i>0;i--){
            if(A[i]==A[0]){
                A[i]--;
                continue;
            }
            break;
        }
        while(left<=right){
            int mid=(left+right)/2;
            System.out.println(left+"  "+right+"  "+mid);
            if(mid==A.length-1||A[mid]>A[mid+1]){
                rorateIndex=mid;
                break;
            }else if(A[0]<=A[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        left=target>A[0]?0:rorateIndex+1;
        right=target>A[0]?rorateIndex:A.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(A[mid]==target)
                return true;
            else if(A[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return false;

        // write your code here
    }


}
