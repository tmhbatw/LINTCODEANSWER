package LINTCODE12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1111 {
    /*Description
    * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
    * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
    * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
    * */

    public int findLongestChain(int[][] pairs) {
        if(pairs==null||pairs.length==0)
            return 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int result=1;
        int pre=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            int[] cur=pairs[i];
            if(cur[0]>pre){
                result++;
                pre=cur[1];
            }else{
                pre=Math.min(pre,cur[1]);
            }
        }
        return result;
        // Write your code here
    }
}
