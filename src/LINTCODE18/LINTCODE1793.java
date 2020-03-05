package LINTCODE18;

public class LINTCODE1793 {
    /*Description
    * 给定了一系列销售数字，最小索引元素的索引是什么，左侧和右侧的所有元素的总和相等。 该阵列可能无法重新排序。
    * 例如，给定数组sales = [1,2,3,4,6]，我们看到1 + 2 + 3 = 6，使用基于零的索引，sales [3] = 4是寻求的值。索引是3。
    * */

    public int BalancedSalesArray(int[] sales) {
        int leftSum=0;
        for(int i=1;i<sales.length;i++)
            leftSum+=sales[i];
        int preSum=0;
        for(int i=0;i<sales.length;i++){
            if(preSum==leftSum)
                return i;
            preSum+=sales[i];
            leftSum-=sales[i+1];
        }
        return 0;
        // write your code here
    }
}
