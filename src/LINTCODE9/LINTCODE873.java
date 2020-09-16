package LINTCODE9;

public class LINTCODE873 {
    /*Description
    * 给定一个二维网格, 其中有一棵树, 一个松鼠和几枚坚果. 松鼠同一时间内最多只能携带一枚坚果.
    * 松鼠可以向上, 下, 左, 右的相邻的方格移动.
    * 请问, 松鼠要把所有的坚果送到树下, 最少需要移动多少格距离.
    * */

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result=0;
        for(int[] cur:nuts){
            result+=getDistance(cur,tree)*2;
        }
        int min=Integer.MAX_VALUE;
        for(int[] cur:nuts){
            min=Math.min(min,getDistance(squirrel,cur)-getDistance(cur,tree));
        }
        return result+min;
        // Write your code here
    }

    private int getDistance(int[] point1, int[] point2){
        return Math.abs(point2[0]-point1[0])+Math.abs(point2[1]-point1[1]);
    }
}
