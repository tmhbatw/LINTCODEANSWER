package LINTCODE14;

import java.util.Arrays;

public class LINTCODE1345 {
    /*Description
    *在无限平面上，机器人最初位于（0，0）并朝北。 机器人可以接收以下三个指令之一：
    * “ G”：直线前进1个单位；
    * “ L”：向左旋转90度；
    * “ R”：向右转90度。
    * 机器人执行顺序给出的指令，一直重复执行。
    * 当且仅当平面中存在一个使机器人永远不会离开环时，才返回true。
    * */

    public boolean isRobotBounded(String instructions) {
        int[][] next=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[] pos=new int[]{0,0};
        int index=0;
        int time=4;
        while(time-->0) {
            for (int i = 0; i < instructions.length(); i++) {
                char cur = instructions.charAt(i);
                switch (cur) {
                    case 'R':
                        index = (index + 1) % 4;
                        break;
                    case 'L':
                        index = (index + 4 - 1) % 4;
                        break;
                    default:
                        pos[0] += next[index][0];
                        pos[1] += next[index][1];
                }
            }
        }
        return pos[0]==0&&pos[1]==0;
        // write your code here
    }
}
