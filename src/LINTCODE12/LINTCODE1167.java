package LINTCODE12;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1167 {
    /*Description
    * 取出数组中最大的三个数
    * */

    public List<Integer> TopThree(List<Integer> arr) {
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        for(int cur:arr){
            if(cur==max1||cur==max2||cur==max3)
                continue;
            if(max1<cur){
                max3=max2;
                max2=max1;
                max1=cur;
            }else if (max2<cur){
                max3=max2;
                max2=cur;
            }else if(max3<cur){
                max3=cur;
            }
        }
        List<Integer> result=new ArrayList<>();
        result.add(max1);
        result.add(max2);
        result.add(max3);
        return result;
        // write your code here
    }
}
