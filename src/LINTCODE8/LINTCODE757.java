package LINTCODE8;

public class LINTCODE757 {
    /*Description
    * 给定一个整数数组，求出无序整数的最短子序列的长度。如果一组整数既不递减也不递增，则称为无序。
    * [提示：开始检查它是否递增/递减并返回0，否则检查是否存在无序的三元组。如果是，则返回3，否则返回0]
    * */

    /*Solution
    * 简单的判断连续数字大小关系的题目
    * 需要注意的是数字相等也算递进关系
    * */

    public int shortestUnorderedArray(int[] arr) {
        if(arr.length<=2)
            return 0;
        boolean cur=arr[0]<arr[1];
        for(int i=2;i<arr.length;i++){
            boolean temp=arr[i-1]<arr[i];
            if(temp!=cur)
                return 3;
        }
        return 0;
        // write your code here
    }
}
