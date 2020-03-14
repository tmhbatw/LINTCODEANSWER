package LINTCODE9;

public class LINTCODE894 {
    /*Description
    * 给一个 无序数组，对其排序。只能对数组执行以下操作。
    * flip(arr, i): 翻转数组中下标从 0 到 i 的元素
    * 与传统的排序算法不同，传统的排序算法试图以尽可能少的比较进行排序。我们的目标是用尽可能少的翻转来实现排序。
    * */

    static class FlipTool{
        static void flip(int[] arr ,int i){
            for(int j=0;j<i/2;j++){
                int temp=arr[j];
                arr[j]=arr[i-j];
                arr[i-j]=temp;
            }
        }
    }

    public void pancakeSort(int[] array) {
        for(int j=array.length-1;j>=0;j--){
            int maxIndex=j;
            int max=array[j];
            for(int i=maxIndex-1;i>=0;i--){
                if(array[i]>max){
                    maxIndex=i;
                    max=array[i];
                }
            }
            FlipTool.flip(array,maxIndex);
            FlipTool.flip(array,j);
        }
        // Write your code here
    }
}
