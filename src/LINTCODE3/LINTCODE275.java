package LINTCODE3;

import java.util.Arrays;

public class LINTCODE275 {
    /*Description
    * 有一些车辆在停放中。给定一个整数数组stops，代表每辆车停车的位置。给定一个整数k，
    * 现在你要建造一个移动车棚。需要车棚在这些车辆之间移动时（车棚的最前端不超过最前面的车，
    * 车棚的最后端不超过最后面的车），均能成功覆盖到k辆车。请求出能满足要求的最短车棚的长度。
    * */

    public int calculate(int[] stops, int k) {
        Arrays.sort(stops);
        int result=Integer.MIN_VALUE;
        for(int i=0;i<stops.length-k+1;i++){
            result=Math.max(result,stops[i+k-1]-stops[i]+1);
            if(i!=stops.length-k)
                result=Math.max(result,stops[i+k]-1-stops[i]+1);
        }
        return result;
        // write your code here
    }
}
