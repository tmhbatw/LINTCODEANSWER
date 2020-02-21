package LINTCODE15;

public class LINTCODE1424 {
    /*Description
    * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
    * B.length >= 3
    * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
    * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
    * 给出一个整数数组 A，返回最长 “山脉” 的长度。
    * 如果不含有 “山脉” 则返回 0。
    * */

    public int longestMountain(int[] A) {
        int result=0;
        for(int i=1;i<A.length-1;i++){
            if(A[i]<=A[i+1]||A[i]<=A[i-1])
                continue;
            int curSum=0;
            int index=i;
            while(index>0&&A[index-1]<A[index])
                index--;
            curSum+=i-index;
            index=i;
            while(index<A.length-1&&A[index]<A[index+1])
                index++;
            curSum+=index-i;
            result=Math.max(curSum+1,result);
            i=index+1;
        }
        return result;
        // write your code here
    }
}
