package NOWCODER;

import java.util.Scanner;

public class zijietiaodong_2019_7 {
    /*Description
    * 起初， 机器人在编号为0的建筑处。每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E, 下一步它将跳到第个k+1建筑。它将会得到或者失去正比于与H(k+1)与E之差的能量。
    * 如果 H(k+1) > E 那么机器人就失去 H(k+1) - E 的能量值，否则它将得到 E - H(k+1) 的能量值。
    * 游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位。现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏？
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int[] height=new int[s.nextInt()];
        for(int i=0;i<height.length;i++){
            height[i]=s.nextInt();
        }


        double result=0;
        int count=0;
        for(int i=0;i<height.length;i++){
            result+=height[i]/Math.pow(2,i+1);
        }
        System.out.println( (int)(result)+1);
    }
}
