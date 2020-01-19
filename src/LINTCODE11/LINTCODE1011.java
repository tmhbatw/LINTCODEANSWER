package LINTCODE11;

public class LINTCODE1011 {
    /*Description
     *把字符串S中的字符从左到右写入行中。 每行最大宽度度为100，如果往后新写一个字符导致该行宽度超过100，则写入下一行。
     * 注意：一个字符的宽度不为1！给定一个数组widths，其中widths[0]是字符a的宽度，widths[1]是字符b的宽度，...，widths[25]是字符'z'的宽度。
     * 问：把S全部写完，至少需要多少行？最后一行用去的宽度是多少？ 将结果作为长度为2的整数列表返回。
     * */

    public int[] numberOfLines(int[] widths, String S) {
        int occupy=0;
        int row=1;
        for(int i=0;i<S.length();i++){
            int cur=widths[S.charAt(i)-'a'];
            if(occupy+cur>100){
                row++;
                occupy=cur;
            }else
                occupy+=cur;
        }
        return new int[]{row,occupy};
        // Write your code here
    }
}
