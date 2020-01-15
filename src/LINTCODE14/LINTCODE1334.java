package LINTCODE14;

public class LINTCODE1334 {
    /*Description
    * 给定一个数组，将数组向右移动k步，其中k为非负数。
    * */

    public int[] rotate(int[] nums, int k) {
        int length=nums.length;
        k%=length;
        int[] rotate=new int[length];
        for(int i=0;i<length;i++){
            rotate[i]=nums[(i+length-k)%length];
        }
        return rotate;
        // Write your code here
    }
}
