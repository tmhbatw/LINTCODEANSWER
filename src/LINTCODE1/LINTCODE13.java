package LINTCODE1;

public class LINTCODE13 {

    /*Description
    * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
    * If target does not exist in source, just return -1.
    * */

    /*Solution
    * 可以使用暴力解法，需要O(n^2)复杂度
    * 简化思路——可以使用KMP算法，可以省去一部分查找过程
    * 这里选择暴力解法
    * */

    public int strStr(String source, String target) {
        int slength=source.length();
        int tlength=target.length();
        if(tlength==0)
            return 0;
        if(tlength>slength)
            return -1;
        int i=0,j=0;//i用来表示源字符串字符下标，j用来表示目标字符下标
        while(i<slength&&j<tlength){
            if(source.charAt(i)==target.charAt(j)){
                i++;
                j++;
            }
            else{
                i-=(j-1);
                j=0;
            }
        }
        int result=j==tlength?i-j:-1;
        return result;
    }



}
