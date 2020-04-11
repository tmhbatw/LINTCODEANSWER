package LINTCODE10;

import datastructure.Point;

import java.util.*;

public class LINTCODE996 {
    /*Description
    *给出一系列平面直角坐标系中的整数点 (x, y)(x,y)，从 00 开始编号，第 ii 个点的编号为 ii。
    * 不存在任意两点的横坐标相同，找出能构成的最大斜率直线的两个点的编号 (a,b)(a,b)。如果有多个这样的点对，返回字典序最小的点对。
    * */

    class Pair{
        int x;
        int y;
        int index;
        public Pair(int x,int y ,int index){
            this.x=x;
            this.y=y;
            this.index=index;
        }
    }

    public List<Integer> getPoints(Point[] points) {
        Pair[] p=new Pair[points.length];
        for(int i=0;i<points.length;i++){
            p[i]=new Pair(points[i].x,points[i].y,i);
        }
        Arrays.sort(p, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.x-o2.x;
            }
        });
        double max=Double.MIN_VALUE;
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<p.length;i++){
            double cur=(p[i].y-p[i-1].y)*1.0/(p[i].x-p[i-1].x);
            if(cur>max){
                List<Integer> curResult=new ArrayList<>();
                curResult.add(Math.min(p[i].index,p[i-1].index));
                curResult.add(Math.max(p[i].index,p[i-1].index));
                result=curResult;
                max=cur;
            }
            else if(cur==max){
                int index1=Math.min(p[i].index,p[i-1].index);
                int index2=Math.max(p[i].index,p[i-1].index);
                if(index1==result.get(0)&&index2<result.get(1)||index1<result.get(0)){
                    List<Integer> curResult=new ArrayList<>();
                    curResult.add(index1);
                    curResult.add(index2);
                }
            }
        }
        return result;
        // Write your code here
    }
}
