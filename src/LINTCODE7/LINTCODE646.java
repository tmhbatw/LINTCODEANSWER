package LINTCODE7;

public class LINTCODE646 {
    /*Description
    *给出一个字符串。找到字符串中第一个不重复的字符然后返回它的下标。如果不存在这样的字符，返回 -1。
    * */
    public int firstUniqChar(String s) {
        int[] cur=new int[128];
        for(int i=0;i<s.length();i++){
            cur[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
            if(cur[s.charAt(i)]==1)
                return i;
        }
        return -1;
        // write your code here
    }

}
