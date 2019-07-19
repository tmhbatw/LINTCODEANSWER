package NOWCODER;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class yizhandaodi_3 {
    /*Description
    * 你要买n件物品，其中有一些是凳子。 商场正在举行促销活动，如果购物车中有至少一个凳子，那么你可以半价购买这个购物车中最贵的一个物品。 你有m辆购物车，请最小化你的花费。
    * 输入描述:
    * 第一行一个整数t表示数据组数 (1 ≤ t ≤ 100)。每组数据第一行两个整数n,m (1 ≤ n,m ≤ 1000)，接下来n行每行两个整数ai,bi，分别表示第i件物品的价格以及它是否是凳子 (1 ≤ ai ≤ 105, 0 ≤ bi ≤ 1)。
    * 输出描述:
    * 每组数据输出一行一个实数表示最小花费，保留一位小数。
    * */
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int num=s.nextInt();
        double[] res=new double[num];
        for(int i=0;i<num;i++){
            int n=s.nextInt();
            int m=s.nextInt();
            int half=0;
            PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
            for(int j=0;j<n;j++){
                queue.add(s.nextInt());
                half+=s.nextInt()==0?0:1;
            }
            half=Math.min(half,m);
            double result=0;
            while(half-->0){
                result+=queue.poll()*1.0/2;
            }
            while(!queue.isEmpty()){
                result+=queue.poll();
            }
            res[i]=result;
        }
        for(double cur:res){
            if(cur-(int)cur==0.0)
                System.out.println((int)cur);
            else{
                System.out.println(cur);
            }
        }
    }
}
