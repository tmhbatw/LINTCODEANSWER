package LINTCODE4;

import java.util.Arrays;

public class LINTCODE344 {
    /*Description
    * 给定长度为N的正整数数组song代表N首歌的时间
    * 请你任选其中若干首播放，在满足开始播放最后一首歌的时间小于M的情况下求播放歌曲的最长时间
    * 每首歌只能被播放一次你可以任意指定播放顺序
    * */

    public int LongestSongTime(int[] song, int M) {
        Arrays.sort(song);
        boolean[] dp=new boolean[M];
        dp[0]=true;
        for(int i=0;i<song.length-1;i++){
            for(int j=M-1;j>0;j--){
                if(j>=song[i]&&dp[j-song[i]])
                    dp[j]=true;
            }
        }
        for(int i=M-1;i>=0;i--){
            if(dp[i])
                return i+song[song.length-1];
        }
        return 0;
        // write your code here
    }
}
