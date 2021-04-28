package LINTCODE4;

public class LINTCODE307 {
    /*Description
    * 给定两个字符串A和B，任务是尽可能将A转换为B。唯一允许的操作是将A中的任意字符插入到最前面。
    * 查找是否有可能转换字符串。如果是，那么输出转换所需的最小操作数。如果没有，则输出-1。
    * 注意：0 ≤ A,B的长度 ≤ 100000
    * */

    //solution
    //从后往前找a匹配b的最长子序列
    public int transform(String A, String B) {
        int[] num=new int[128];
        for(int i=0;i<A.length();i++)
            num[A.charAt(i)]++;
        for(int i=0;i<B.length();i++)
            num[B.charAt(i)]--;
        for(int i=0;i<128;i++)
            if(num[i]!=0)
                return -1;
        int right=A.length()-1;
        int matchIndex=right;
        while(right>=0){
            if(A.charAt(right)==B.charAt(matchIndex)){
                matchIndex--;
            }
            right--;
        }
        return matchIndex+1;
        // write your code here
    }
}
