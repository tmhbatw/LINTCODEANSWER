package LINTCODE2;

public class LINTCODE141 {
    /*Description
    * 实现 int sqrt(int x) 函数，计算并返回 x 的平方根。
    * Challenge
    * O(log(x))
    * */

    /*Solution
    *要求时间复杂度为log（x），那么想到了二分法
    * 如果中间值平方大于等于目标值则左移，小于则右移
    * 最后剩下的值必定正好为所求的值+1
    * */

    public int sqrt(int x) {
        if(x<=1)
            return x;
        int i=0,j= x;
        while(i<j){
            int mid=(i+j)/2;
            if(x/mid>=mid){
                i=mid+1;
            }
            else{
                j=mid;
            }
        }
        return j-1;
        // write your code here
    }
}
