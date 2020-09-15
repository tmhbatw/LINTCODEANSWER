package LINTCODE13;

public class LINTCODE1272 {
    /*Description
    * 给定一个 n x n 矩阵，每一行和每一列都按照升序排序，找出矩阵中的第 k 小元素。
    * 注意是需要找将所有元素有序排列的第 k 小元素，而不是第 k 个互不相同的元素。
    * */

    public int kthSmallest(int[][] matrix, int k) {
        int row=matrix.length;
        int col=matrix[0].length;
        int min=matrix[0][0];
        int max=matrix[row-1][col-1];
        int res=0;
        while(min<=max){
            int mid=min+(max-min)/2;
            int time=binarySearch(matrix,mid);
            System.out.println(mid+"  "+time+" "+binarySearch(matrix,mid+1));
            if(time<=k-1&&binarySearch(matrix,mid+1)>=k)
                return mid;
            if(time<=k-1)
                min=mid+1;
            else
                max=mid-1;
        }
        return min;
        // write your code here
    }


    //用来返回小于当前选定number的个数
    public int binarySearch(int[][] matrix,int number){
        int result=0;
        for(int[] cur:matrix){
            if(cur[0]>=number)
                continue;
            int length=cur.length;
            int left=0;
            int right=length-1;
            int mid=0;
            while(left<=right){
                mid=left+(right-left)/2;
                if(cur[mid]<number&&(mid==length-1||cur[mid+1]>=number))
                    break;
                if(cur[mid]>=number){
                    right=mid-1;
                }else
                    left=mid+1;
            }
            result+=mid+1;
        }
        return result;
    }

}
