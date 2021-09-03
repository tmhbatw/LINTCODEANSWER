package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1722 {
    /*Description
    * 你的音乐播放器里有 N 首不同的歌，在旅途中，你的旅伴想要听 L 首歌（不一定不同，即，允许歌曲重复）。
    * 请你为她按如下规则创建一个播放列表：
    * 每首歌至少播放一次。
    * 一首歌只有在其他 K 首歌播放完之后才能再次播放。
    * 返回可以满足要求的播放列表的数量。由于答案可能非常大，请返回它模 10^9 + 7 的结果。
    * */


    int mod = 1000000007;
    public int numMusicPlaylists(int N, int L, int K) {
        int[][] dp=new int[L][N+1];
        dp[0][1]=N;
        for(int i=1;i<L;i++){
            for(int j=1;j<=N;j++){
                long cur= (long) (dp[i - 1][j - 1]) *(N-j+1)+ (long) dp[i - 1][j] *Math.max(0,j-K);
                cur%=mod;
                dp[i][j]= (int) cur;
            }
        }
        for(int[] cur:dp){
            System.out.println(Arrays.toString(cur));
        }
        return dp[L-1][N];
        // write your code here
    }

    public static void main(String[] args){
        new LINTCODE1722().numMusicPlaylists(3,3,1);
    }
}
