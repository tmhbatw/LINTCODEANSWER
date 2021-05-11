package LINTCODE3;

import java.util.Arrays;

public class LINTCODE287 {
    /*Description
    * 你有一个长度为n的pos数组表示可以提供视野的真视守卫，第
    * i个真视守卫可以覆盖[pos[i][0],pos[i][1]]区间.请问最少需要多少个真视守卫，可以覆盖[0,L]区间.
    * 即∀i∈[0,L]∃j pos[j][0] ≤i≤ pos[j][1].
    * */

    public int getMiniumVisionWard(int[][] pos, int L) {
        Arrays.sort(pos,(o1,o2)->{
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];});
        int count=0;
        int curRight=0;
        int max=0;
        for(int i=0;i<pos.length;i++){
            if(curRight>=L)
                return count;
            if(pos[i][0]<=curRight){
                max=Math.max(max,pos[i][1]);
            }else{
                curRight=max;
                if(curRight<pos[i][0])
                    return -1;
                count++;
                max=pos[i][1];
            }
        }
        return max>=L?count+1:-1;
        // write your code here
    }
}
