package LINTCODE15;

import java.util.HashSet;

public class LINTCODE1493 {
    /*Description
    * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
    * -2：向左转 90 度
    * -1：向右转 90 度
    * 1 <= x <= 9：向前移动 x 个单位长度
    * 在网格上有一些格子被视为障碍物。
    * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
    * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
    * 返回从原点到机器人的最大欧式距离的平方。
    * */


    static int[][] move=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int robotSim(int[] commands, int[][] obstacles) {
        int direction=0;//0表示向北    1表示向东     2表示向南      3表示向西
        int x=0,y=0;
        HashSet<String> set=new HashSet<>();
        for(int[] cur:obstacles)
            set.add(cur[1]+" "+cur[0]);
        for(int cur:commands){
            switch (cur){
                case -1:
                    direction++;
                    if(direction==4)
                        direction=0;
                    break;
                case -2:
                    direction--;
                    if(direction==-1)
                        direction=3;
                    break;
                default:
                    for(int i=0;i<cur;i++){
                        /*                        System.out.println((x+move[direction][0])+" "+(y+move[direction][1]));*/
                        if(set.contains((x+move[direction][0])+" "+(y+move[direction][1])))
                            break;
                        x+=move[direction][0];
                        y+=move[direction][1];
                    }
            }
        }
        return x*x+y*y;
        // write your code here
    }

    public static void main(String[] args){
        for(int[] num:move){
            System.out.println(num[0]+" "+num[1]);
        }
    }




}
