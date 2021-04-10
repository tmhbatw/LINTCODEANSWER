package LINTCODE6;

public class LINTCODE571 {
    /*Description
    * 给定一个数组，保证数组中的值的范围在 [0, n - 1] 之间。若数组中不含有重复的元素，
    * 函数的返回 true ；若数组中含有重复的元素，则返回 false 。
     * */

    public boolean isUnique(int[] arr) {
        for(int i=0;i<arr.length;i++){
            while(arr[i]!=i){
                //int temp=arr[i];
                if(arr[arr[i]]==arr[i])
                    return false;
                int temp=arr[arr[i]];
                arr[arr[i]]=arr[i];
                arr[i]=temp;
            }
        }
        return true;

        // write your code here
    }
    public static void main(String[] args){

    }
}
