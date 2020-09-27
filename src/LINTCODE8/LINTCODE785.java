package LINTCODE8;

public class LINTCODE785 {
    /*Description
    * 有一个机器人位于一个 m × n 个网格的右上角。
    * 机器人每一时刻只能向下或者向左移动一步。机器人试图达到网格的左下角。每个网格上有一个数字权值，机器人希望它走到左下角的路径权值和最大。
    * 问这个最大路径权值和是多少？
    * */

    public int maxWeight(int[][] nums) {
        int row=nums.length,col=nums[0].length;
        for(int i=col-2;i>=0;i--){
            nums[0][i]+=nums[0][i+1];
        }
        for(int i=1;i<row;i++){
            nums[i][col-1]+=nums[i-1][col-1];
        }
        for(int i=1;i<row;i++){
            for(int j=col-2;j>=0;j--){
                nums[i][j]+=Math.max(nums[i-1][j],nums[i][j+1]);
            }
        }
        return nums[row-1][0];
        //
    }
}
