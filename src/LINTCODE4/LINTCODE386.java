package LINTCODE4;

public class LINTCODE386 {

    /*Description
    * Given a string S, find the length of the longest substring T that contains at most k distinct characters.
    * */

    /*Solution
    * 依然使用一个滑动窗口，不过滑动条件稍微改变
    * */

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0||s.length()==0)
            return 0;
        int[] num=new int[128];
        int index=0;
        int exist=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(num[s.charAt(i)]!=0){
                num[s.charAt(i)]++;
            }else if(exist<k){
                exist++;
                num[s.charAt(i)]++;
            }else{
                num[s.charAt(i)]++;
                result=Math.max(i-index,result);
                while(--num[s.charAt(index)]!=0&&index<i){
                    index++;
                }
                index++;
            }
        }
        result=Math.max(s.length()-index,result);
        return result;
        // write your code here
    }
}
