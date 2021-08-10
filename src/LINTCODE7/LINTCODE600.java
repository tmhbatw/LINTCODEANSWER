package LINTCODE7;

public class LINTCODE600 {
    /*Description
    * 一个由二进制矩阵表示的图，0 表示白色像素点，1 表示黑色像素点。黑色像素点是联通的，
    * 即只有一块黑色区域。像素是水平和竖直连接的，给一个黑色像素点的坐标 (x, y) ，返回囊括所有黑色像素点的矩阵的最小面积。
     * */

    public int minArea(char[][] image, int x, int y) {
        int l1=Integer.MAX_VALUE,l2=0;
        int r1=Integer.MAX_VALUE,r2=0;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(image[i][j]=='1'){
                    l1=Math.min(l1,i);
                    l2=Math.max(l2,i);
                    r1=Math.min(r1,j);
                    r2=Math.max(r2,j);
                }
            }
        }
        return (l2-l1+1)*(r2-r1+1);
        // write your code here
    }
}
