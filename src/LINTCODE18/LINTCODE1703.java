package LINTCODE18;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1703 {
    /*Description
    * 给定二维平面中的一组点，确定由这些点形成的矩形的最小面积，其边平行于x和y轴。
    * 如果没有任何矩形，则返回0。
    * */

    public int minimumAreaRectangle(int[][] points) {
        Set<String> set=new HashSet<>();
        for(int[] point:points){
            set.add(point[0]+","+point[1]);
        }
        int result=Integer.MAX_VALUE;
        int length=points.length;
        for(int i=0;i<length;i++){
            int[] point1=points[i];
            for(int j=i+1;j<length;j++){
                int[] point2=points[j];
                if(point1[0]!=point2[0]&&point1[1]!=point2[1]){
                    if(set.contains(point1[0]+","+point2[1])&&set.contains(point2[0]+","+point1[1])){
                        result=Math.min(result,Math.abs(point2[0]-point1[0])*Math.abs(point2[1]-point1[1]));
                    }
                }
            }
        }
        return result==Integer.MAX_VALUE?0:result;
        // Write your code here.
    }

}
