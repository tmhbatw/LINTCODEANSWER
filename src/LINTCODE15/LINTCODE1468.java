package LINTCODE15;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1468 {
    /*Description
    * 给定一个数组 a[]，其中除了2个数，别的数都出现了2次，找到不重复的2个数并返回。
    * */

    public List<Integer> theTwoNumbers(List<Integer> a) {
        int num=0;
        for(int cur:a)
            num^=cur;
        int i=0;
        for(i=0;i<32;i++){
            if(((num>>i)&1)==1)
                break;
        }
        int num1=0,num2=0;
        for(int cur:a){
            if(((cur>>i)&1)==1)
                num1^=cur;
            else
                num2^=cur;
        }
        List<Integer> list=new ArrayList<>();
        list.add(num1);
        list.add(num2);
        return list;
        // Write your code here
    }

}
