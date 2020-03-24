package LINTCODE9;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE831 {
    /*Description
    * 输入 n，求所有符合 x^2+y^2+z^2 = n 的 x, y, z 的方案数。（x, y, z为非负整数）
    * */

    public int threeSum2(int n) {
        int max= (int) Math.sqrt(n);
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<=max;i++)
            set.add(i*i);
        int result=0;
        for(int i=0;i<=max;i++){
            int curI=i*i;
            for(int j=i;j<=max;j++){
                int curJ=j*j;
                int target=n-curI-curJ;
                if(target<curJ)
                    continue;
                if(set.contains(target))
                    result++;
            }
        }
        return result;
        // Write your code here
    }


}
