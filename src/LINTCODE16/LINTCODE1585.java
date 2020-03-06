package LINTCODE16;

import java.util.Arrays;

public class LINTCODE1585 {
    /*Description
    * 在x轴上分布着n个石子，用arr数组来表示它们的位置。现在要求把这些石子移动到1，3，5，7，2n-1 或者 2，4，6，8，2n。
    * 也就是说，要求这些石子移动到从1开始连续的奇数位，或从2开始连续的偶数位上。返回最少移动的次数。
    * 每次只可以移动1块石头，只能把石头往左移动一个单位或往右移动一个单位。同一个位置不能同时有两块石头。
    * */

    public int movingStones(int[] arr) {
        Arrays.sort(arr);
        int move1=0;
        int move2=0;
        int index1=1;
        int index2=2;
        for(int num:arr){
            move1+=Math.abs(num-index1);
            move2+=Math.abs(num-index2);
            index1+=2;
            index2+=2;
        }
        return Math.min(move1,move2);
        // Write your code here
    }
}
