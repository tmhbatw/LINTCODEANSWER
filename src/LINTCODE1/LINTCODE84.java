package LINTCODE1;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE84 {
    /*Description
    *Given 2*n + 2 numbers, every numbers occurs twice except two, find them
    * */

    /*Solution
    *每一个数取异或操作，则剩下的值必定为两个不重复数的亦或值
    * 因为两个数不相同，则结果必定有一位为1
    * 将这一位为0或1分为两组，则两个不重复数必定在不同的组中
    * 两个组分别取异或值即可
    * */


    public List<Integer> singleNumberIII(int[] A) {
        int result=0;
        for(int i=0;i<A.length;i++){
            result^=A[i];
        }
        int count=0;
        for(int i=0;i<32;i++){
            if((result>>i&1)==1){
                count=i;
                break;
            }
        }
        int result1=0,result2=0;
        for(int i=0;i<A.length;i++){
            if((A[i]>>count&1)==1){
                result1^=A[i];
            }else{
                result2^=A[i];
            }
        }
        List<Integer> res=new ArrayList<>();
        res.add(result1);
        res.add(result2);
        return res;
        // write your code here
    }
}
