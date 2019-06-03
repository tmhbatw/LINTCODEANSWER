package LINTCODE2;

public class LINTCODE148 {

    /*Description
    * 给定一个包含红，白，蓝且长度为 n 的数组，将数组元素进行分类使相同颜色的元素相邻，并按照红、白、蓝的顺序进行排序。
我们可以使用整数 0，1 和 2 分别代表红，白，蓝。
    * */

    /*Solution
    *s设置一个起点下标和一个终点下标m、n
    * 遍历数组，每当发现一个0，就与起点交换位置，每发现一个2就与终点交换位置，分别进行起点++以及终点--
    * */

    public void sortColors(int[] nums) {
        int m=0,n=nums.length-1;
        for(int i=0;i<=n;i++){

            if(nums[i]==0){
                nums[i]=nums[m];
                nums[m++]=0;
            }else if(nums[i]==2){
                nums[i--]=nums[n];
                nums[n--]=2;
            }
        }

        // write your code here
    }

}
