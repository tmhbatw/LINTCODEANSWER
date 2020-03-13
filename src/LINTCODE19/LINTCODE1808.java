package LINTCODE19;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1808 {
    /*Description
    *在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。
    * （一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
    * 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。
    * 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。
    * 如果无法做到，返回 -1.
    * */

    public int minDominoRotations(int[] A, int[] B) {
        int A_Length=A.length;
        int B_Length=B.length;
        if(A_Length==0||B_Length==0)
            return 0;
        if(A_Length!=B_Length)
            return -1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A_Length;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            map.put(B[i],map.getOrDefault(B[i],0)+1);
        }
        int value=-1;
        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getValue()>=A_Length)
                value=(int)entry.getKey();
        }
        if(value==-1)
            return -1;
        int countA=0;
        int countB=0;
        for(int i=0;i<A_Length;i++){
            if(A[i]!=value&&B[i]!=value)
                return -1;
            if(A[i]!=value)
                countA++;
            if(B[i]!=value){
                countB++;
            }
        }
        return Math.min(countA,countB);
        // write your code here
    }


}
