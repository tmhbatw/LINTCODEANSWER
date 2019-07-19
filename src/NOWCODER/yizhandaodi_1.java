package NOWCODER;

import java.util.PriorityQueue;
import java.util.Scanner;

public class yizhandaodi_1 {

    /*Description
    给你一个长度为n的序列，你每次可以将一个序列分割成两个连续的的子序列，
    分割的代价为原序列的总和。 现在允许你在初始时将序列重新排列一次。 问分割成n个长度为1的序列的最大总代价是多少？
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        long max=0;
        for(int i=0;i<n;i++){
            int cur=s.nextInt();
            max+=cur;
            queue.add(cur);
        }
        long result=0;
        while(queue.size()>1){
            result+=max;
            max-=queue.poll();
        }
        System.out.println(result);
    }
}
