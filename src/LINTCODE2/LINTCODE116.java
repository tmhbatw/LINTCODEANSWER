package LINTCODE2;

public class LINTCODE116 {
    /*Description
    * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
    * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
    * 判断你是否能到达数组的最后一个位置。
    * */

    /*Solution
    * 创建一个boolean数组用来判断是否能达到最后一个位置
    * 贪心算法，用一个变量保存数组当前位置能达到的最远位置
    * 当当前位置与最远位置相同的停止遍历
    * 比较当前位置是否为最远位置即可
    * */

    public boolean canJump(int[] A) {
        int max=1;
        for(int i=0;i<max;i++){
            max=Math.max(max,i+A[i]);
            if(max>=A.length)
                return true;
        }
        return max>=A.length-1;
        // write your code here
    }


}
