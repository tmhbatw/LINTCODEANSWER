package LINTCODE9;

import datastructure.Point;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE820 {
    /*Description
    * 给出一个 set，问能不能找到四个点组成平行于坐标轴的矩形，如果能输出 "YES"，否则输出 "NO"。
    * */

    public class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String rectangle(Point[] pointSet) {
        Set<String> set=new HashSet<>();
        for(Point cur:pointSet){
            set.add(cur.x+" "+cur.y);
        }
        for(int i=0;i<pointSet.length;i++){
            int curX=pointSet[i].x;
            int curY=pointSet[i].y;
            for(int j=i+1;j<pointSet.length;j++){
                int currX=pointSet[j].x;
                int currY=pointSet[j].y;
                if(curX==currX||curY==currY)
                    continue;
                if(set.contains(curX+" "+currY)&&set.contains(currX+" "+curY))
                    return "YES";
            }
        }
        return "NO";
        // Write your code here
    }
}
