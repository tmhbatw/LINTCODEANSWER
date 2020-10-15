package LINTCODE14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1306 {
    /*Description
    * 有一个集合组成的list，如果有两个集合有相同的元素，将他们合并。返回最后还剩下几个集合。
    * */

    public int setUnion(int[][] sets) {
        int max=0;
        for(int[] cur:sets){
            Arrays.sort(cur);
            max=Math.max(cur[cur.length-1],max);
        }
        int[] dp=new int[max+1];
        for(int i=0;i<max+1;i++)
            dp[i]=i;
        boolean[] used=new boolean[max+1];
        for(int i=0;i<=max;i++)
            dp[i]=i;
        for(int[] cur:sets){
            for(int i=0;i<cur.length;i++){
                used[cur[i]]=true;
            }
        }
        for(int[] cur:sets){
            int type=getType(dp,cur[0]);
            for(int i=1;i<cur.length;i++){
                dp[getType(dp,cur[i])]=type;
            }
        }
        Set<Integer> result=new HashSet<>();
        for(int i=0;i<max+1;i++){
            if(used[i]){
                result.add(getType(dp,i));
            }
        }
        return result.size();
        // Write your code here
    }

    private int getType(int[] dp, int index){
        while(index!=dp[index])
            return getType(dp,dp[index]);
        return index;
    }
}
