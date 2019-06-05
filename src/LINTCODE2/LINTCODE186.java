package LINTCODE2;

import datastructure.Point;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE186 {

    /*Description
    *给出二维平面上的n个点，求最多有多少点在同一条直线上。
    * */

    /*Solution
    * 对于每一个节点，求出每一个其他点与它的斜率，如果斜率相同则说明在同一直线上
    * 计算最多的数量即可
    * */


    public int maxPoints(Point[] points) {
        if(points==null||points.length==0)
            return 0;
        if(points.length<=2)
            return points.length;
        int max=0;
        for(int i=0;i<points.length;i++){
            int same=1;//存储相同的节点
            int special=0;//存储斜率不存在的情况
            Map<Double,Integer> map=new HashMap<>();
            for(int j=i+1;j<points.length;j++){
                if(points[i].x==points[j].x&&points[i].y==points[j].y)
                    same++;
                else if(points[i].x==points[j].x)
                    special++;
                else{
                    double slope=(points[i].y-points[j].y)*1.0/(points[i].x-points[j].x);
                    if(map.containsKey(slope)){
                        map.put(slope,map.get(slope)+1);
                    }else
                        map.put(slope,1);
                }
            }
            for(Map.Entry entry:map.entrySet()) {
                special=Math.max(special, (Integer) entry.getValue());
            }
            max=Math.max(same+special,max);
        }
        return max;
    }

}
