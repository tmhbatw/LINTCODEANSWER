package LINTCODE4;

public class LINTCODE311 {
    /*Description
    * 给定一个字符串，判断此字符串能否通过交换某些字符使之变成一个回文串
    * */

    public boolean isPalindrome(String s) {
        int[] time=new int[128];
        for(int i=0;i<s.length();i++){
            time[s.charAt(i)]++;
        }
        int flag=0;
        for(int i=0;i<128;i++){
            if(time[i]%2==1)
                flag++;
        }
        return flag<=1;
        // write your code here
    }
}
