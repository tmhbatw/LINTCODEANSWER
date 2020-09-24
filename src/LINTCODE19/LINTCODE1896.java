package LINTCODE19;

public class LINTCODE1896 {
    /*Description
    * 给定一个n * m 的矩阵 carrot, carrot[i][j] 表示(i, j) 坐标上的胡萝卜数量。
    * 从矩阵的中心点出发，每一次移动都朝着四个方向中胡萝卜数量最多的方向移动，保证移动方向唯一。
    * 返回你可以得到的胡萝卜数量。
    * */

    public int PickCarrots(int[][] carrot) {
        return getRes(carrot,(carrot.length+1)/2-1,(carrot[0].length+1)/2-1);
        // write your code here
    }

    private int getRes(int[][] carrot, int i,int j){
        int res=carrot[i][j];
        int[][] nextPos=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int row=carrot.length,col=carrot[0].length;
        boolean[][] reached=new boolean[row][col];
        while(true){
            reached[i][j]=true;
            int index=-1;
            int curMax=Integer.MIN_VALUE;
            for(int ii=0;ii<4;ii++){
                int curI=i+nextPos[ii][0];
                int curJ=j+nextPos[ii][1];
                if(curI<row&&curI>=0&&curJ<col&&curJ>=0&&!reached[curI][curJ]){
                    if(carrot[curI][curJ]>curMax){
                        curMax=carrot[curI][curJ];
                        index=ii;
                    }
                }
            }
            if(index==-1)
                return res;
            i+=nextPos[index][0];
            j+=nextPos[index][1];
            res+=carrot[i][j];
        }
    }
}
