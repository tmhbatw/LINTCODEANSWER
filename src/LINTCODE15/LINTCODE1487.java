package LINTCODE15;

import java.util.Arrays;

public class LINTCODE1487 {
    /*Description
    * 给定一个数组arr，问，能否从数组里找到3个元素作为三条边的边长，使三条边能够组成一个三角形。若能，返回yes,若不能，返回no
    * */

    public String judgingTriangle(int[] arr) {
        int length=arr.length;
        if(length>=44)
            return "yes";
        if(length<=2)
            return "no";
        Arrays.sort(arr);
        for(int i=0;i<length;i++){
            int cur=arr[i];
            for(int j=i+1;j<length-1;j++){
                if(cur+arr[j]>arr[j+1])
                    return "yes";
            }
        }
        return "no";
        // Write your code here
    }
}
