package LINTCODE7;

import datastructure.ParentTreeNode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LINTCODE612 {

    /*Description
    * 给定一些 points 和一个 origin，从 points 中找到 k 个离 origin 最近的点。
    * 按照距离由小到大返回。如果两个点有相同距离，则按照x值来排序；若x值也相同，就再按照y值排序。
    * */

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) {
            x = a; y = b;
        }
    }


    private int getDistance(Point a,Point origin){
        return (a.x-origin.x)*(a.x-origin.x)+(a.y-origin.y)*(a.y-origin.y);
    }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> queue=new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int oo1=getDistance(o1,origin);
                int oo2=getDistance(o2,origin);
                if(oo1==oo2){
                    if(o1.x==o2.x)
                        return o1.y-o2.y;
                    return o1.x-o2.x;
                }
                return oo1-oo2;
            }
        });
        for(Point cur:points){
            queue.add(new Point(cur.x,cur.y));
        }
        Point[] res=new Point[k];
        for(int i=0;i<k;i++){
            res[i]=queue.poll();
        }
        return res;
        // write your code here
    }
}
