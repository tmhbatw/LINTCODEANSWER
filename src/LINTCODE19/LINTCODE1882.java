package LINTCODE19;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE1882 {
    /*Description
    * 现在给你两个长度均为N的整数数组 A 和 B。
    * 当(A[0]+...A[K-1])，(A[K]+...+A[N-1])，(B[0]+...+B[K-1]) 和 (B[K]+...+B[N-1])四个和值大小相等时，
    * * 称索引K是一个公平索引。也就是说，索引K 可以使得A， B 两个数组被分成两个非空数组，这四个子数组的和值相等。
    * 例如，数组A = [4,-1,0,3]，B = [-2,5,0,3]，那么索引 K = 2是公平的，子数组的和相等：4+(-1) = 3;
    * 0+3 = 3; -2 + 5 = 3 and 0 + 3 = 3。现在请你计算公平索引的个数。
    * */

    public int CountIndexes(List<Integer> A, List<Integer> B) {
        Long sumA=0L;
        for(int cur:A)
            sumA+=cur;
        Set<Integer> set=new HashSet<>();
        Long curSum=0L;
        for(int i=0;i<A.size()-1;i++){
            curSum+=A.get(i);
            if(curSum*2==sumA)
                set.add(i);
        }
        Long sumB=0L;
        for(int cur:B)
            sumB+=cur;
        if(!sumB.equals(sumA))
            return 0;
        curSum=0L;
        int result=0;
        for(int i=0;i<B.size();i++){
            curSum+=B.get(i);
            if(curSum*2==sumB){
                if(set.contains(i))
                    result++;
            }
        }
        return result;
        //
    }
}
