package NOWCODER;

import java.util.Scanner;

public class yizhandaodi_5 {
    /*Description
    * A和B在同一条路上，他们之间的距离为 k 米。A现在想见到B，所以A开车以 x km/h的速度朝着B的方向行驶，同时B也以 y km/h的速度朝着A的方向走去。
    * A的车有 n 个档位，每个档位有不同的速度。现在假设A开车去见B，求他最快和最慢在几秒后能见到B。
    * 输入描述:
    * 一开始一行三个整数 n, m, k ,代表A的车的档位数、B行走的速度和AB之间的距离。接下来一行 n 个整数，代表A的车的不同档位的行驶速度。
    * 输出描述:
    *  一行两个整数，代表A最快/最慢在几秒后能见到B(向上取整）。
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int k=s.nextInt();
        int[] speed=new int[n];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            speed[i] = s.nextInt();
            min=Math.min(speed[i],min);
            max=Math.max(speed[i],max);
        }
        long maxx=max+m;
        double minRes=3.6*k/(maxx);
        if(minRes==(int)minRes){
            System.out.print((int)minRes+" ");
        }else{
            System.out.print(((int)minRes+1)+" ");
        }
        long minn=min+m;
        double maxRes=3.6*k/(minn);
        if(maxRes==(int)maxRes){
            System.out.print((int)maxRes);
        }else{
            System.out.print((int)maxRes+1);
        }
    }
}
