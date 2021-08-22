package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1273 {
    /*Description
    *
    * */

    public int getMaxiumLength(String[] strs) {
        Arrays.sort(strs);
        int[] dp=new int[26];
        System.out.print("[");
        for(int i=0;i<26;i++)
            System.out.print((char)(i+'a')+", ");
        System.out.println();
        for(String cur:strs){
            if(!isMatch(cur))
                continue;
            int first=cur.charAt(0)-'a';
            int last=cur.charAt(cur.length()-1)-'a';
            for(int i=first;i>=0;i--){
                dp[last]=Math.max(dp[i]+cur.length(),dp[last]);
            }
            for(int i=last+1;i<26;i++){
                dp[i]=Math.max(dp[i],dp[last]);
            }
            System.out.println(Arrays.toString(dp));
        }
        int result=0;
        for(int cur:dp){
            result=Math.max(result,cur);
        }
        return result;
        //
    }

    private boolean isMatch(String cur){
        for(int i=1;i<cur.length();i++){
            if(cur.charAt(i)<cur.charAt(i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String[] res=new String[]{"kkklll","gllllx","efg","ghlllv",
                "beg","e","aaglloot","fffgl","jklmn","aaaaij"};
        System.out.println(new LINTCODE1273().getMaxiumLength(res));
    }
}
