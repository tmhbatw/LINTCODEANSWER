package LINTCODE4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE359 {
    /*Description
    *给出 nn 根木棍，每次切割可以将 1 根木棍切成 2 段。
    * 请计算出最少切割几次，可以从所有木棍中选出 3 根，组成一个 正三角形 。
    * */

    public int makeEquilateralTriangle(int[] lengths) {
        Arrays.sort(lengths);
        int length=lengths.length;
        for(int i=2;i<length;i++){
            if(lengths[i]==lengths[i-1]&&lengths[i]==lengths[i-2])
                return 0;
        }
        HashSet<Integer> set=new HashSet<>();
        for (int value : lengths) {
            set.add(value);
        }
        if(set.contains(lengths[0]*2))
            return 1;
        for(int i=1;i<length;i++){
            if(set.contains(lengths[i]*2)||(lengths[i]==lengths[i-1]&&i!=length-1))
                return 1;
        }
        return 2;
        // write your code here.
    }
}
