package LINTCODE6;

public class LINTCODE524 {
    /*Description
    *实现一个leftpad库
    * */


    static public String leftPad(String originalStr, int size) {
        int length=size-originalStr.length();
        while(length-->0){
            originalStr=' '+originalStr;
        }
        return originalStr;
        // Write your code here
    }

    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        int length=size-originalStr.length();
        while(length-->0){
            originalStr=padChar+originalStr;
        }
        return originalStr;
        // write your code here
    }
}
