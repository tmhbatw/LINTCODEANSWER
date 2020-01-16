package LINTCODE13;

public class LINTCODE1270 {
    /*Description
    * 给定一个任意的表示勒索信内容的字符串，和另一个字符串表示杂志的内容，
    * 写一个方法判断能否通过剪下杂志中的内容来构造出这封勒索信，若可以，返回 true；否则返回 false。
    * 杂志字符串中的每一个字符仅能在勒索信中使用一次。
    * */

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] time=new int[26];
        for(int i=0;i<magazine.length();i++){
            time[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(time[ransomNote.charAt(i) - 'a']==0)
                return false;
            time[ransomNote.charAt(i) - 'a']--;
        }
        return true;
        // Write your code here
    }
}
