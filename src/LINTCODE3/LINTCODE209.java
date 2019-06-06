package LINTCODE3;

public class LINTCODE209 {
    /*Description
    * Find the first unique character in a given string. You can assume that there is at least one unique character in the string.
    * */

    /*Solution
    *用一个数组保存每一个字符出现的数目即可
    * */
    public char firstUniqChar(String str) {
        int[] s=new int[26];
        for(int i=0;i<str.length();i++){
            s[str.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length;i++){
            if(s[i]==1){
                char result= (char) (i+'a');
                return result;
            }
        }
        return 'a';
        // Write your code here
    }

}
