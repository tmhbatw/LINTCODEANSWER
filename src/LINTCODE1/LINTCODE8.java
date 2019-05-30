package LINTCODE1;

import java.util.Arrays;

public class LINTCODE8 {
    /*Desciption
    *Given a string(Given in the way of char array) and an offset, rotate the string by offset in place. (rotate from left to right)
    * Challenge Rotate in-place with O(1) extra memory.
    * */

    /*Solution
    * 此题难点：原地旋转
    * 解决方法：创建一个字符串为结果字符串，并将这个字符串赋值给字符串数组
    * */
        public static void rotateString(char[] str, int offset) {
            int length=str.length;
            if(length==0||offset%length==0)
                return;
            offset%=length;
            String result= new String((Arrays.copyOfRange(str, length-offset, length)))+ new String((Arrays.copyOfRange(str, 0, length-offset)));
            str=result.toCharArray();
            // write your code here
        }

}
