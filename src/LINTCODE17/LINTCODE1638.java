package LINTCODE17;

public class LINTCODE1638 {
    /*Description
    *给定一个包含n个小写字母的字符串s，要求将字符串划分成若干个连续子串，子串中的字母类型相同，
    * 同时子串的字母个数不超过k，输出最少划分的子串数量。
    * */


    public int getAns(String s, int k) {
        int result=0;
        for(int i=0;i<s.length();i++){
            result++;
            char cur=s.charAt(i);
            int time=1;
            while(i<s.length()-1&&time<k&&s.charAt(i+1)==cur){
                i++;
                time++;
            }
        }
        return result;
        // Write your code here
    }
}
