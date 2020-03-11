package LINTCODE16;

public class LINTCODE1597 {
    /*Description
    * 在具有R行和C列的二维网格上，我们在（r0，c0）并面朝向东出发。
    * 网格的西北角位于第一行和第一列，网格的东南角位于最后一行和一列。
    * 现在，我们以顺时针螺旋形状行走，以访问该网格中的每个位置。
    * 每当我们移动到网格边界之外时，我们继续在网格外部行走（但稍后可能会回到网格边界。）
    * 最终，我们将经过网格的所有R * C的空间。返回一个坐标列表，表示网格按访问顺序排列的位置。
    * */

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int time=R*C;
        int[][] result=new int[R*C][2];
        result[0]=new int[]{r0,c0};
        int index=1;
        int[][] near=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int curNumber=0;
        int flag=1;
        while(index<time){
            for(int i=0;i<4;i++){
                flag++;
                if(flag==2){
                    curNumber++;
                    flag=0;
                }
                for(int j=0;j<curNumber;j++){
                    r0+=near[i][0];
                    c0+=near[i][1];
                    if(r0<R&&r0>=0&&c0<C&&c0>=0)
                        result[index++]=new int[]{r0,c0};
                }
            }
        }
        return result;
        // Write your code here.
    }
}
