package LINTCODE11;

public class LINTCODE1040 {
    /*Description
    * 整数数组arr（存在相同元素），将其拆分成一些“块”（分区），
    * 并单独对每个块进行排序. 连接它们之后，结果为升序数组.
    * 可以划分最多多少块？
    * */

    public int maxChunksToSorted(int[] arr) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            int max=Integer.MIN_VALUE;
            count++;
            while(true){
                max=Math.max(max,arr[i]);
                int j=arr.length-1;
                for(;j>i;j--){
                    if(arr[j]<max)
                        break;
                }
                if(i==j)
                    break;
                i++;
            }
        }
        return count;
        // Write your code here
    }
}
