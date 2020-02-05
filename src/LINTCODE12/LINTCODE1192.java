package LINTCODE12;

public class LINTCODE1192 {
    /*Description
    * 给定一组两个字符串，你需要找到这组两个字符串中最长的非公共子序列。
    * 最长的非公共子序列被定义为这两个字符串之一的最长子序列，此子序列满足：它不是其他字符串的子序列。
    * 子序列是可以通过删除一些字符而不改变其余元素的顺序从一个序列导出的序列。
    * 可以说，任何字符串都是自身的子序列，空字符串是任何字符串的子序列。
    * 输入两个字符串，输出最长的非公共子序列的长度。 如果最长的非公共子序列不存在，则返回-1。
    * */

    public int findLUSlength(String a, String b) {
        if(a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
        // write your code here
    }
}
