package LINTCODE17;

public class LINTCODE1644 {
    /*Description
    * 二维平面上给定n个整点，问任意四个点为顶点，能够构成的矩形的最大面积是多少？如果不能构成矩形，则输出0
    * */

    public int getMaximum(int[][] a) {
        if(a.length == 0)
            return 0;
        boolean[][] map=new boolean[1001][1001];
        for(int [] cur:a)
            map[cur[0]][cur[1]]=true;
        int result=0;
        for(int i=0;i<a.length;i++){
            int [] cur=a[i];
            for(int j=i+1;j<a.length;j++){
                int[] curr=a[j];
                if(map[cur[0]][curr[1]]&&map[curr[0]][cur[1]])
                    result=Math.max(result,Math.abs(curr[0]-cur[0])*Math.abs(curr[1]-cur[1]));
            }
        }
        return result;
        // write your code here
    }
}
