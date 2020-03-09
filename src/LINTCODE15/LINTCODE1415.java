package LINTCODE15;

public class LINTCODE1415 {
    /*Description
    * 输入为整数数组 arr，请你返回结果数组 ans，使得 ans[i] 为 arr 中除了 arr[i] 以外的所有数的乘积。
    * */

    public int[] getProduct(int[] arr) {
        int length=arr.length;
        if(length==0)
            return new int[0];
        if(length==1)
            return new int[]{0};
        int[] last=new int[length];
        last[length-1]=1;
        for(int j=length-2;j>=0;j--){
            last[j]=last[j+1]*arr[j+1];
        }
        int[] result=new int[length];
        int pre=1;
        for(int i=0;i<length;i++){
            result[i]=pre*last[i];
            pre*=arr[i];
        }
        return result;
        // Write your code here
    }
}
