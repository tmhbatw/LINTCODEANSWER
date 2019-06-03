package LINTCODE2;

public class LINTCODE143 {
    /*Description
    * 给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
    * */

    /*Solution
    * 当然也可以快速排序
    * 与中间的颜色数字比较，进行前后交换
    * 左边的数字与左边颜色中间数字进行比较，右边数字与右边颜色中间数字进行比较
    * */

    //下为计数排序方法
    public void sortColors2(int[] colors, int k) {
        int[] kk=new int[k];
        for(int i=0;i<colors.length;i++){
            kk[colors[i]-1]++;
        }
        int index=0;
        for(int i=0;i<kk.length;i++){
            int curr=kk[i];
            while(curr!=0){
                colors[index++]=i+1;
            }
        }
        // write your code here
    }
}
