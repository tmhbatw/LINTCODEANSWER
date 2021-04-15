package LINTCODE13;

public class LINTCODE1246 {
    /*Description
    * 给定一个仅包含大写英文字母的字符串，您可以将字符串中的任何一个字母替换为的另一个字母，最多替换k次。
    * 执行上述操作后，找到最长的，只含有同一字母的子字符串的长度。
    * */

    public int characterReplacement(String s, int k) {
        int[] dp=new int[26];
        int length=s.length();
        int right=-1;
        int result=0;
        for(int i=0;i<length;i++){
            while(right<length-1&&isMatch(dp,s.charAt(right+1),k)){
                right++;
            }
            result=Math.max(result,right-i+1);
            dp[s.charAt(i)-'A']--;
        }
        return result;
        // write your code here
    }

    private boolean isMatch(int[] dp,char next,int k){
        dp[next-'A']++;
        int sum=0,max=0;
        for(int cur:dp){
            sum+=cur;
            max=Math.max(max,cur);
        }
        if(sum-max>k){
            dp[next-'A']--;
            return false;
        }
        return true;
    }
}
