package LINTCODE18;

public class LINTCODE1700 {
    /*Description
    * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
    * 返回[0, 1, ..., N] 的任意排列 A 使得对于所有i = 0, ..., N-1，都有：
    * 如果 S[i] == "I"，那么 A[i] < A[i+1]
    * 如果 S[i] == "D"，那么 A[i] > A[i+1]
    * */

    /*Solution
    * I则从小到大排序，D则从大到小
    * */

    public int[] diStringMatch(String S) {
        int[] result=new int[S.length()+1];
        int left=0,right=S.length();
        for(int i=0;i<S.length();i++){
            char cur=S.charAt(i);
            if(cur=='I')
                result[i]=left++;
            else
                result[i]=right--;
        }
        result[S.length()]=left;
        return result;
    }
}
