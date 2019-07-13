package LINTCODE6;

import java.util.ArrayList;
import java.util.Arrays;

public class LINTCODE510 {

    /*Description
    * Given a 2D boolean matrix filled with False and True, find the largest rectangle containing all True and return its area.
    * */

    /*Solution
    *遍历每一行，每一行上计算最大矩形的面积
    * 最后进行比较即可
    * */

    public int maximalRectangle(boolean[][] matrix) {
        int result=0;
        int height[]=new int[matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                height[j]=matrix[i][j]?height[j]+1:0;
            }
            System.out.println(Arrays.toString(height));
            result=Math.max(getCurrMax(height),result);
        }
        return result;
        // write your code here
    }

    public int getCurrMax(int[] height){
        int result=0;
        for(int i=0;i<height.length;i++){
            int minHeight=height[i];
            for(int j=i+1;j<height.length;j++){
                if(height[j]>=minHeight)
                    continue;
                else{
                    minHeight=height[j];
                    result=Math.max(result,(j-i)*minHeight);
                }
            }
        }
        return result;
    }
}
