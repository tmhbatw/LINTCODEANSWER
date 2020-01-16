package LINTCODE14;

import java.util.Arrays;

public class LINTCODE1338 {
    /*Description
    * 停车场里停着许多汽车。 停车位是一条很长的直线，每米都有一个停车位。
    *  当前很多汽车停放，您想通过建造屋顶来遮雨挡雨。 要求至少有k辆车的车顶被车顶遮盖，
    * 要覆盖k辆车的车顶的最小长度是多少？
    * */


    public int ParkingDilemma(int[] cars, int k) {
        Arrays.sort(cars);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<cars.length-k+1;i++){
            min=Math.min(min,cars[i+k-1]-cars[i]);
        }
        return min+1;
        // write your code here
    }
}
