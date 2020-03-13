package LINTCODE9;

public class LINTCODE898 {
    /*Description
    * 一个二维数组，每一行都只有0和1，前面部分是0，后一部分是1，找到数组里面所有行中最左边的1所在的列数。
    * 样例:给出 arr = [[0,0,0,1],[1,1,1,1]], 返回 0。
    * 解释：arr[1][0]为所有行中最左边的1，其所在的列为0。
    * 给出 arr = [[0,0,0,1],[0,1,1,1]], 返回 1。
    * */

    public int getColumn(int[][] arr) {
        if(arr.length==0)
            return 0;
        int row=arr.length;
        int col=arr[0].length;
        int index=col;
        for(int i=0;i<arr[0].length;i++){
            if(arr[0][i]==1){
                index=i;
                break;
            }
        }
        for(int i=1;i<row;i++){
            if(arr[i][index]==0)
                continue;
            while(index>=1&&arr[i][index-1]==1)
                index--;
        }
        return index;
        // Write your code here
    }
}
