package LINTCODE11;

public class LINTCODE1086 {
    /*Description
    * 给定两个字符串A和B，找到A必须重复的最小次数，以使得B是它的子字符串。 如果没有这样的解决方案，返回-1。
    * */

    /*Solution
    * 可以使用StringBuilder减少空间的开销
    * */

    public int repeatedStringMatch(String A, String B) {
        StringBuilder tempS = new StringBuilder(A);
        int count = 1;
        while(tempS.length() < B.length()){
            tempS.append(A);
            count++;
        }
        if(tempS.indexOf(B)!=-1) {
            return count;
        }
        tempS.append(A);
        if(tempS.indexOf(B)!=-1) {
            return count+1;
        }
        return -1;
    }
}
