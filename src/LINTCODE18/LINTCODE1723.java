package LINTCODE18;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LINTCODE1723 {
    /*Description
    * 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
    * 如果您最多可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，
    * 并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
    * */

    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> startQ=new LinkedList<>();
        Queue<int[]> endQ=new LinkedList<>();
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        int result=Integer.MAX_VALUE;
        for(int[] start:startQ){
            for(int[] end:endQ){
                int dis=Math.abs(start[0]-end[0])+Math.abs(start[1]-end[1]);
                if(dis<=k)
                    result=Math.min(result,dis+start[2]+end[2]-2);
            }
        }
        return result;
        // write your code here
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int year=Integer.parseInt(s.nextLine());
        boolean isLeap=true;
        if(year%400==0){

        }else if(year%100==0){
            isLeap=false;
        }else if(year%4==0)
            isLeap=true;
        if(isLeap)
            System.out.println("is a leap year");
        else
            System.out.println("not a leap year");

        // write your code here
        // read data from console

        // output the answer to the console according to the
        // requirements of the question

    }
}
