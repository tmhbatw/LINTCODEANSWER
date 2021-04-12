package LINTCODE14;

public class LINTCODE1375 {
    /*Description
    *给定一个仅包含小写字母的字符串 S.
    * 返回 S 中至少包含 k 个不同字符的子串的数量.
    * */

    public long kDistinctCharacters(String s, int k) {
        long result=0;
        int right=0;
        int length=s.length();
        int curCount=0;
        int[] dp=new int[26];
        for(int i=0;i<length;i++){
            while(curCount<k){
                if(right==length)
                    return result;
                char cur=s.charAt(right++);
                dp[cur-'a']++;
                if(dp[cur-'a']==1)
                    curCount++;
            }
            result+=length-right;
            int cur=s.charAt(i)-'a';
            dp[cur]--;
            if(dp[cur]==0)
                curCount--;
        }
        return result;
        // Write your code here
    }
}
