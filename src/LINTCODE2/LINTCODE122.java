package LINTCODE2;

public class LINTCODE122 {
    /*Description
    *Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
    * */

    /*Solution
    * 找到一个峰值点向前逐个遍历获取最大值（强行省去一部分步骤以通过测试用例）；
    * */

    public int largestRectangleArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; ++i) {
            if (i + 1 < height.length && height[i] <= height[i + 1]) {
                continue;
            }
            int minH = height[i];
            for (int j = i; j >= 0; --j) {
                minH = Math.min(minH, height[j]);
                int area = minH * (i - j + 1);
                max =Math. max(max, area);
            }
        }
        return max;
        // write your code here
    }
}
