package LINTCODE11;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1046 {
    /*Description
    * 给定两个整数 L 和 R ，找到闭区间[L, R] 范围内，计算置位位数为质数的整数个数。
    * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
    * */

    public int countPrimeSetBits(int L, int R) {
        HashSet<Integer> set=new HashSet<>();
        int[] prime=new int[]{2,3,5,7,11,13,17};
        for(int cur:prime)
            set.add(cur);
        int result=0;
        for(int i=L;i<=R;i++){
            if(set.contains(getBits(i)))
                result++;
        }
        return result;

    }

    private int getBits(int cur){
        int res=0;
        for(int i=0;i<32;i++){
            res+=(cur>>i)&1;
        }
        return res;
    }
}
