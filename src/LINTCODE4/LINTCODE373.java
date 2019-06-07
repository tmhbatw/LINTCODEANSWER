package LINTCODE4;

public class LINTCODE373 {
    /*Description
    * 分割一个整数数组，使得奇数在前偶数在后。
    * */

    /*Solution
    * 创建前后两个指针，当前面的指针发现偶数，后面的指针发现奇数时，交换两个指针所指向的数字
    * */

    public void partitionArray(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){
            if((nums[i]&1)==1){
                i++;
                continue;
            }
            if((nums[j]&1)==0){
                j--;
                continue;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        // write your code here
    }

}
