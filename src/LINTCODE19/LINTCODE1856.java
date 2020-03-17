package LINTCODE19;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1856 {
    /*Description
    * 小明喜欢玩文字游戏，今天他希望在一个字符串的子串中找到回文串。
    * 回文串是从左往右和从右往左读相同的字符串，例如121和tacoca。子串是一个字符串中任意几个连续的字符构成的字符串。
    * 现在给你一个字符串s,求出s的回文串个数？
    * 例如，s=mokkori。它的一些子串是[m，o，k，r，i，mo，ok，mok，okk，kk，okko]，每个粗体元素都是s的一个回文子串，总共有7个不同的回文。
    * */

    public int countSubstrings(String s) {
        Set<String> set=new HashSet<>();
        int length=s.length();
        for(int i=0;i<length;i++){
            set.add(s.charAt(i)+"");
            int left=i-1,right=i+1;
            while(left>=0&&right<length&&s.charAt(left)==s.charAt(right)){
                set.add(s.substring(left,right+1));
                left--;
                right++;
            }
            left=i;
            right=i+1;
            while(left>=0&&right<length&&s.charAt(left)==s.charAt(right)){
                set.add(s.substring(left,right+1));
                left--;
                right++;
            }
        }
        return set.size();
        // Write your code here.
    }
}
