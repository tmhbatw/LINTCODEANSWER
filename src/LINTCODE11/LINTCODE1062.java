package LINTCODE11;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1062 {
    /*Description
    * 一张image通过一个2-D整数数组来表示，每一个整数代表图片的像素值（从0到65535）。
    * 给定一个坐标 (sr, sc) 代表洪水填充的起始像素（行和列），以及一个像素颜色newColor，“洪水填充”整张图片。
    * 为了实现一个“洪水填充”，考虑起始像素点，以及与起始像素相同颜色的起始像素4向连接的任何像素，
    * 以及与这些像素4向相连的任何像素（同样和起始像素相同颜色），以此类推。把所以之前提到的像素点替换成新的颜色。
    * 最终，返回修改后的图片。
    * */

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int temp=image[sr][sc];
        image[sr][sc]=newColor;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int[][] near=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] curNear:near){
                int ii=cur[0]+curNear[0];
                int jj=cur[1]+curNear[1];
                if(ii>=0&&ii<image.length&&jj>=0&&jj<image[0].length&&image[ii][jj]==temp){
                    image[ii][jj]=newColor;
                    queue.add(new int[]{ii,jj});
                }
            }
        }
        return image;
        // Write your code here
    }
}
