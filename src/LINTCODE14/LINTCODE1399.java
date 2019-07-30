package LINTCODE14;

public class LINTCODE1399 {
    /*Description
     * 有n个硬币排成一排，每次要你从最左边或者最右侧拿出一个硬币。总共拿k次，写一个算法，使能拿到的硬币的和最大。
     * */

    public int takeCoins(int[] list, int k) {
        int res=0;
        for(int i=0;i<k;i++)
            res+=list[i];
        int max=res;
        int length=list.length;
        for(int i=0;i<k;i++){
            res-=list[k-i-1];
            res+=list[length-i-1];
            max=Math.max(res,max);
        }
        return max;
        // Write your code here
    }
}
