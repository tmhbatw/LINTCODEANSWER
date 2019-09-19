package LINTCODE3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE278 {
    /*Description
    * 实现可以在许多图像编辑程序中看到的“绘制填充”功能。也就是说，给定屏幕（由二维颜色阵列表示），
    * 一个点和新的颜色，填充指定点周围与起始颜色相同的点，直到颜色全部变为新颜色。
    * */

    private static int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    public boolean paintFill(int[][] screen, int x, int y, int newColor) {
        for(int[] cur:screen){
            System.out.println(Arrays.toString(cur));
        }
        int ini=screen[x][y];
        if(newColor==ini)
            return false;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            screen[x][y]=newColor;
            for(int [] curPos:near){
                int curX=cur[0]+curPos[0];
                int curY=cur[1]+curPos[1];
                if(curX<0||curX>=screen.length||curY<0||curY>=screen[0].length)
                    continue;
                if(screen[curX][curY]==ini)
                    queue.add(new int[]{curX,curY});
            }
        }
        for(int cur[]:screen){
            System.out.println(Arrays.toString(cur));
        }
        return true;
        // write your code here.
    }


}
