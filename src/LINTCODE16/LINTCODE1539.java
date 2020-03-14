package LINTCODE16;

public class LINTCODE1539 {
    /*Description
    *一张图片以二维数组byte[][]形式的像素点来排列，数组的每一个元素代表一个像素位(0 或 1)。
    * 现在需要将这些像素点翻转，首先将每一行的像素点对称翻转，然后将每一位上的像素点翻转(0->1,1->0)。
    * */

    public int[][] flippedByte(int[][] Byte) {
        int row=Byte.length;
        int col=Byte[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col/2;j++){
                int temp=Byte[i][j];
                Byte[i][j]=1-Byte[i][col-j-1];
                Byte[i][col-j-1]=1-temp;
            }
        }
        if(col%2==1){
            col=col/2;
            for(int i=0;i<row;i++){
                Byte[i][col]=1-Byte[i][col];
            }
        }
        return Byte;
        // Write your code here
    }
}
