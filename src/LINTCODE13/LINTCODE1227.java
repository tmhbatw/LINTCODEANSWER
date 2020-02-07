package LINTCODE13;

public class LINTCODE1227 {
    /*Description
    * 给你一个非空字符串，判断它能否通过重复它的某一个子串若干次（两次及以上）得到。
    * 字符串由小写字母组成，并且它的长度不会超过10000。
    * */

    public boolean repeatedSubstringPattern(String s) {
        int length=s.length();
        for(int i=length/2;i>=0;i--){
            if(length%i==0){
                int time=length/i;
                StringBuilder curr=new StringBuilder(s.substring(0,i));
                StringBuilder cur=new StringBuilder();
                while(time-->0){
                    cur.append(curr);
                }
                if(cur.toString().equals(s))
                    return true;
            }
        }
        return false;
        // write your code here
    }
}
