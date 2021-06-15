package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1191 {
    /*Description
    *给定一组字符串，你需要找到这组字符串中最长的非公共子序列。 最长的非公共子序列被定义为这些字符串之一的最长子序列，并且此子序列不应该是其他字符串的子序列。
    * 子序列是可以通过删除一些字符而不改变其余元素的顺序从一个序列导出的序列。可以说，任何字符串都是自身的子序列，空字符串是任何字符串的子序列。
    * 输入将是字符串列表，输出需要是最长的非公共子序列的长度。 如果最长的非公共子序列不存在，则返回-1。
    * */

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs,((o1, o2) -> o2.length()-o1.length()));
        int length=strs.length;
        for(int i=0;i<length;i++){
            boolean isLongLength=true;
            for(int j = 0; j<length; j++){
                if(strs[j].length()<strs[i].length())
                    break;
                if(i==j)
                    continue;
                if (isMatch(strs[i], strs[j])) {
                    isLongLength = false;
                    break;
                }
            }
            if(isLongLength)
                return strs[i].length();
        }
        return -1;
        // write your code here
    }

    private boolean isMatch(String s1,String s2){
        int index=0;
        for(int j=0;j<s2.length();j++){
            if(index==s1.length())
                return true;
            if(s2.charAt(j)==s1.charAt(index))
                index++;
        }
        return index==s1.length();
    }
}
