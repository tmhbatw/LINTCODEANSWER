package LINTCODE3;

public class LINTCODE212 {

    /*Description
    设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
    你的程序还需要返回被替换后的字符串的长度。
    * */

    /*Solution
    *统计数据十分简单，赋值的时候注意要赋值到原地
    * 因为害怕数据被覆盖掉，所以应该从后往前赋值
    * */

    public int replaceBlank(char[] string, int length) {
        if(string==null)
            return 0;
        int num=length;
        for(int i=0;i<string.length;i++){
            if(string[i]==' ') {
                length += 2;
            }
        }
        for(int i=num-1,j=length-1;i>=0;i--){
            if(string[i]==' '){
                string[j--]='0';
                string[j--]='2';
                string[j--]='%';
            }else{
                string[j--]=string[i];
            }
        }
        return length;
        // write your code here
    }
}
