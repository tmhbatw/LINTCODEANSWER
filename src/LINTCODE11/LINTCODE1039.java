package LINTCODE11;

public class LINTCODE1039 {
    /*Description
    * 数组arr，是[0,1，...，arr.length - 1]的一个排列.将数组拆分成若干“块”（分区），并单独对每个块进行排序，使得连接这些块后，结果为排好的升序数组.
    * 问最多可以分多少块？
    * */

    public int maxChunksToSorted(int[] arr) {
        int result=0;
        int cur=0;
        for(int i=0;i<arr.length;i++){
            result++;
            while(i<=cur){
                if(arr[i]>cur)
                    cur=arr[i];
                i++;
            }
            cur++;
            i--;
        }
        return result;
        // write your code here
    }
}
