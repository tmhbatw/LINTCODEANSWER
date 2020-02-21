package LINTCODE10;

public class LINTCODE982 {
    /*Description
    * 如果一个数字序列由至少三个元素组成并且任何两个连续元素之间的差值相同，则称为等差数列。
    * 举个例子，这些是等差数列：
    * 1, 3, 5, 7, 9
    * 7, 7, 7, 7
    * 3, -1, -5, -9
    * 下面的序列不是等差数列：
    * 1, 1, 2, 5, 7
    * 给一个由 N 个数组成且下标从 0 开始的数组A。这个数组的一个切片是指任意一个整数对 (P, Q) 且满足 0 <= P < Q < N。
    * 如果 A 中的一个切片(P, Q) 是等差切片，则需要满足A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。还需要注意的是，这也意味着 P + 1 < Q。
    * 需要实现的函数应该返回数组 A 中等差切片的数量。
    * */

    public int numberOfArithmeticSlices(int[] A) {
        int result=0;
        for(int i=0;i<A.length;i++){
            if(i>=A.length-2)
                return result;
            int time=2;
            int diff=A[i+1]-A[i];
            while(i+2<A.length&&A[i+2]-A[i+1]==diff){
                time++;
                i++;
            }
            result+=(time-2)*(time-1)/2;
        }
        return result;
        // Write your code here
    }
}
