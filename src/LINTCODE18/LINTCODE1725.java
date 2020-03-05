package LINTCODE18;

public class LINTCODE1725 {
    /*Description
    * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
    * */

    public String ReverseOnlyLetters(String S) {
        char[] c=S.toCharArray();
        int left=0;
        int right=S.length()-1;
        while(left<right){
            if(!isCharacter(c[left])) {
                left++;
                continue;
            }
            if(!isCharacter(c[right])){
                right--;
                continue;
            }
            char temp=c[left];
            c[left]=c[right];
            c[right]=temp;
            left++;
            right--;
        }
        return new String(c);
           // write your code here
    }

    private boolean isCharacter(char cur){
        if(cur<='Z'&&cur>='A'||cur<='z'&&cur>='a')
            return true;
        return false;
    }

}
