package LINTCODE4;

public class LINTCODE326 {
    /*Description
    * 给定一个3\times n3×n 的矩阵 number，并且该矩阵只含有1到9的正整数。
    * 考虑有一个大小为 3\times 33×3 滑动窗口，从左到右遍历该矩阵 number，
    * 那么该滑动窗口在遍历整个矩阵的过程中会有n-2个。
    * 现在你的任务是找出这些滑动窗口是否含有1到9的所有正整数
    * 请返回一个长度为n-2的答案数组，如果第i个滑动窗口含有1到9的所有正整数，那么答案数组的第i个元素为true，否则为false
    * */

    public boolean[] SlidingWindows(int[][] number) {
        int numbers=number[0].length;
        boolean[] result=new boolean[numbers-2];
        int[] cur=new int[9];
        cur[number[0][0]-1]++;
        cur[number[0][1]-1]++;
        cur[number[1][0]-1]++;
        cur[number[1][1]-1]++;
        cur[number[2][0]-1]++;
        cur[number[2][1]-1]++;
        for(int i=2;i<numbers;i++){
            cur[number[0][i]-1]++;
            cur[number[1][i]-1]++;
            cur[number[2][i]-1]++;
            result[i-2]=isTrue(cur);
            cur[number[0][i-2]-1]--;
            cur[number[1][i-2]-1]--;
            cur[number[2][i-2]-1]--;
        }
        return result;
        // write your code here
    }

    private boolean isTrue(int[] cur){
        for(int i=0;i<9;i++)
            if(cur[i]==0)
                return false;
        return true;
    }
}
