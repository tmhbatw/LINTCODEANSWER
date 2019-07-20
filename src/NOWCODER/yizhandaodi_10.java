package NOWCODER;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class yizhandaodi_10 {
    static class Point{
        int x, y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object p){
            Point pp=(Point)p;
            return this.x==pp.x&&this.y==pp.y||this.x==pp.y&&this.y==pp.x;
        }

        @Override
        public int hashCode(){
            return x+y;
        }
    }
    public static void main(String[] args){
        Set<Point> set=new HashSet<>();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int i=0;i<n-1;i++){
            set.add(new Point(s.nextInt(),s.nextInt()));
        }
        int result=0;
        for(int i=0;i<n-1;i++){
            Point cur=new Point(s.nextInt(),s.nextInt());
            if(!set.contains(cur))
                result++;
        }
        System.out.println(result);
    }
}
