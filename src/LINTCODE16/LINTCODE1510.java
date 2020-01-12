package LINTCODE16;

public class LINTCODE1510 {
    /*Description
    * 给定两个由小写字母构成的字符串A 和B，只要我们可以通过交换A中的两个字母得到与B相等的结果，就返回true；否则返回false。
    * */

    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
            return false;
        int index1=-1,index2=-1;
        int[] time=new int[26];//当A、B完全相同时需要判断A、B是否有相同的字符
        for(int i=0;i<A.length();i++){
            time[A.charAt(i)-'a']++;
            if(A.charAt(i)!=B.charAt(i)){
                if(index1==-1)
                    index1=i;
                else if(index2==-1)
                    index2=i;
                else
                    return false;
            }
        }
        if(index1!=-1&&index2==-1)
            return false;
        if(index1==-1){
            for(int i=0;i<26;i++){
                if(time[i]>1)
                    return true;
            }
            return false;
        }
        return A.charAt(index1)==B.charAt(index2)&&A.charAt(index2)==B.charAt(index1);
        // Write your code here
    }
}
