package LINTCODE4;

public class LINTCODE363 {

    /*Description
    * 给出 n 个非负整数，代表一张X轴上每个区域宽度为 1 的海拔图, 计算这个海拔图最多能接住多少（面积）雨水
    * */

    /*Solution
    * 找到数组中最长的高度，从两边向最高高度遍历，如果当前的值大于下一个数的值，则可以存储雨
    * */

    public int trapRainWater(int[] heights) {
        if(heights.length==0)
            return 0;
        int result=0;
        int max=0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[max]){
                max=i;
            }
        }
        int maxHeight=heights[0];
        for(int i=1;i<max;i++){
            result+=maxHeight-heights[i]>0?maxHeight-heights[i]:0;
            maxHeight=Math.max(maxHeight,heights[i]);
        }
        maxHeight=heights[heights.length-1];
        for(int i=heights.length-2;i>max;i--){
            result+=maxHeight-heights[i]>0?maxHeight-heights[i]:0;
            maxHeight=Math.max(maxHeight,heights[i]);
        }
        return result;
        // write your code here
    }
}
