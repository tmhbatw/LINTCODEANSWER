package LINTCODE15;

public class LINTCODE1436 {
    /*Description
    * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
    * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
    * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
    * */

    public int[][] flipAndInvertImage(int[][] A) {
        int length=A[0].length;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<length/2;j++){
                int temp=A[i][j];
                A[i][j]=A[i][length-j-1]==1?0:1;
                A[i][length-j-1]=temp==1?0:1;
            }
            if(length%2==1)
                A[i][length/2]=A[i][length/2]==1?0:1;
        }
        return A;
        // Write your code here
    }
}
