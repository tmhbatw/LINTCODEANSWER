package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1230 {
    /*Description
    *分饼干
    * */

    /*Solution
    * 贪心算法，分给需求最小的小盆友即可
    * */

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result=0;
        for(int i=0;i<s.length;i++){
            if(g.length>result&&s[i]>=g[result])
                result++;
        }
        return result;
        // Write your code here
    }
}
