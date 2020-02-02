package LINTCODE11;

public class LINTCODE1056 {
    /*Description
    * 给定一串只含有小写形式的、排序过的 letters，并且给定一个目标字母 target ，
    * 请找出在给定字母串中，大于目标字母的最小的那一个字母。
    * 在本题中，字母是绕回编址的（即“z”后一位重新变为“a”）。
    * 比如说，如果target = 'z'，而给定字母串为letters = ['a', 'b']，那么答案为“a”。
    * */

    public char nextGreatestLetter(char[] letters, char target) {
        for(int i=0;i<letters.length;i++){
            if(letters[i]>target)
                return letters[i];
        }
        return letters[0];
        // Write your code here
    }
}
