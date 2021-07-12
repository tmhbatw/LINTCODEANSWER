package LINTCODE14;

import java.util.Arrays;

public class LINTCODE1346 {
    /*Description
    * 恶魔抓住了公主（P）并将她关在地牢的右下角。地牢由M x N的2D网格房间组成，。
    * 我们英勇的骑士（K）最初位于左上角的房间，必须通过地牢的房间来拯救公主。
    * 骑士的初始生命值由正整数表示。如果他的生命值在任何时候下降到0或更低，他会立即死亡。
    * 有些房间是由恶魔守卫的，因此骑士进入这些房间时会失去生命值（负整数）；其他房间要么是空的（0），
    * 要么包含增加骑士健康的魔法球（正整数）。为了尽快到达公主所在的地方，骑士决定在每一步中仅向右或向下移动。
    * 编写一个函数来确定骑士的最少的初始生命值，使得他能够拯救公主。
    * 例如，给定下面的地下城，如果骑士遵循最佳路径 右-> 右 -> 下 -> 下，则骑士的初始生命值必须至少为7。
    * */

    public int calculateMinimumHP(int[][] dungeon) {
        int l=1,r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(isMatch(dungeon,mid))
                l=mid;
            else
                r=mid-1;
        }
        return l;
        // write your code here
    }

    private boolean isMatch(int[][] d,int mid){
        int[][] dp=new int[d.length][d[0].length];
        dp[0][0]=d[0][0]+mid;
        for(int i=0;i<d.length;i++){
            for(int j=0;j<d[0].length;j++){
                int val1=(i==0?-1:dp[i-1][j]);
                int val2=(j==0?-1:dp[i][j-1]);
                if(val1<=0&&val2<=0)
                    dp[i][j]=-1;
                else
                    dp[i][j]=Math.max(val1,val2)+d[i][j];
            }
        }
        if(mid<10){
            for(int[] cur:dp){
                System.out.println(Arrays.toString(cur));
            }
            System.out.println();
        }
        return dp[d.length-1][d[0].length-1]>0;
    }
}
