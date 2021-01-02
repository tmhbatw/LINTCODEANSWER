package LINTCODE3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE298 {
    /*Description
    * 输出n以内所有的素数。
    * */

    public List<Integer> prime(int n) {
        List<Integer> result=new ArrayList<>();
        if(n<=1)
            return result;
        result.add(2);
        for(int i=3;i<=n;i+=2){
            if(isPrime(i))
                result.add(i);
        }
        return result;
        // write your code here
    }

    private boolean isPrime(int cur){
        for(int i=3;i<=Math.sqrt(cur);i+=2){
            if(cur%i==0)
                return false;
        }
        return true;
    }
}
