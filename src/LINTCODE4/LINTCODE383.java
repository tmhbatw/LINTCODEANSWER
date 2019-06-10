package LINTCODE4;

public class LINTCODE383 {
    /*Description
    * 给定 n 个非负整数 a1, a2, ..., an, 每个数代表了坐标中的一个点 (i, ai)。画 n 条垂直线，
    * 使得 i 垂直线的两个端点分别为(i, ai)和(i, 0)。找到两条线，使得其与 x 轴共同构成一个容器，以容纳最多水。
    * */

    /*Solution
    * 装水问题，两边中较小的值为水库的长，两边之间的距离为水库的高
    * 找到两者之间的乘积即可
    * */
    public int maxArea(int[] heights) {
        int i=0,j=heights.length-1;
        int result=0;
        while(i<j){
            int height=Math.min(heights[i],heights[j]);
            result=Math.max(height*(j-i),result);
            if(height==heights[i])
                i++;
            else
                j--;
        }
        return result;
        // write your code here
    }
}
