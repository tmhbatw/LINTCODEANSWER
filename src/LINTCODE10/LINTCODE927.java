package LINTCODE10;

public class LINTCODE927 {
    /*Description
    *给定输入的字符数组，逐词翻转数组。单词被定义为不包含空格的字符串.
    * 输入字符数组不包含前导或尾部空格，单词总是用单个空格分隔。
    * */

    public char[] reverseWords(char[] str) {
        reverse(str,0,str.length-1);
        int index=-1;
        for(int i=0;i<str.length;i++){
            if(str[i]==' '){
                reverse(str,index+1,i-1);
                index=i;
            }
        }
        reverse(str,index+1,str.length-1);
        return str;
        // write your code here
    }

    private void reverse(char[] str,int start,int end){
        for(int i=start;i<=(end-start)/2+start;i++){
            char temp=str[i];
            str[i]=str[end-(i-start)];
            str[end-(i-start)]=temp;
        }
    }
}
