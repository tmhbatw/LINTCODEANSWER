package LINTCODE7;

public class LINTCODE678 {
    /*Description
    *给一个字符串 S, 你可以通过在前面添加字符将其转换为回文串.找到并返回用这种方式转换的最短回文串.
    * */

    /*Solution
    * 逐个字符进行比较可以降低时间复杂度
    * */

    public String shortestPalindrome(String str) {
        String res="";
        int index=1;
        for(int i=str.length();i>=0;i--){
            int left=0,right=i;
            boolean isPalindrome=true;
            while(left<=right){
                if(str.charAt(left)!=str.charAt(right)){
                    isPalindrome=false;
                    break;
                }
                left++;
                right--;
            }
            if(isPalindrome){
                index=i;
                break;
            }
        }
        StringBuffer sb= new StringBuffer(str.substring(index)).reverse();
        sb.append(str);
        return sb.toString();
        // Write your code here
    }
}
