package LINTCODE3;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE235 {
    /*Description
    * 将一个整数分解为若干质因数之乘积。
    * */

    /*Solution
    * */

    public List<Integer> primeFactorization(int num) {
        int end= (int) Math.sqrt(num);
        List<Integer> result=new ArrayList<>();
        for(int i=2;i<=end;i++){
            if(i>num)
                break;
            while(num%i==0){
                num/=i;
                result.add(i);
            }
        }
        if(num!=1)
            result.add(num);
        return result;
        // write your code here
    }
}
