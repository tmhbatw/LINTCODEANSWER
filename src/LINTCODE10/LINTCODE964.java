package LINTCODE10;

import java.util.Arrays;

public class LINTCODE964 {
    /*Description
    * 给定一个长度为n个二元组数组lunch表示午餐食物集合，其中lunch[i][0]表示第i种食物的热量，lunch[i][1]表示第i种食物的美味程度
    * 再给定一个长度为m个二元组数组dinner表示晚餐食物集合，其中dinner[i][0]表示第i种食物的热量，dinner[i][1]表示第i种食物的美味程度
    * 请你在午餐集合和晚餐集合各自选取至多一个食物，在满足总的美味程度不小于T的前提下，返回摄入最少的热量和。
    * */

    public int getMinCalories(int[][] lunch, int[][] dinner, int T) {
        Arrays.sort(lunch,(o1,o2)->{
            return o1[1]-o2[1];
        });
        Arrays.sort(dinner,(o1,o2)->{
            return o1[1]-o2[1];
        });
        int right=dinner.length-1;
        int minDinnerHeat=1000000000;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<lunch.length;i++){
            if(lunch[i][1]>=T)
                result=Math.min(result,lunch[i][0]);
        }
        for(int j=0;j<dinner.length;j++){
            if(dinner[j][1]>=T)
                result=Math.min(result,dinner[j][0]);
        }
        for(int i=0;i<lunch.length;i++){
            while(right>=0&&lunch[i][1]+dinner[right][1]>=T){
                minDinnerHeat=Math.min(minDinnerHeat,dinner[right--][0]);
            }
            result=Math.min(result,minDinnerHeat+lunch[i][0]);
        }
        return result>=1000000000?-1:result;
        // write your code here
    }
}
