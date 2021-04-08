package LINTCODE3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE281 {
    /*Description
     *
     * */

    public long painttheCeiling(int s0, int n, int k, int b, int m, long a) {
        long result=0;
        if(n==0)
            return 0;
        int[] list=new int[n];
        long s00=s0;
        list[0]=s0;
        for(int i=1;i<n;i++){
            s00=((k*s00+b)%m+1+s00);
            list[i]=(int)s00;
        }
        int right=n-1;
        for(int i=0;i<n;i++){
            while(right>=0){
                if((long) list[i] *list[right]>a)
                    right--;
                else
                    break;
            }
            result+=right+1;
        }
        return result;
        // write your code here
    }
}
