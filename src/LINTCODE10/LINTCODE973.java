package LINTCODE10;

public class LINTCODE973 {
    /*Description
    * 我们有两个特殊的字符。第一个字符可以用一位 0 来表示。第二个字符可以用两位(10 或者 11)表示。
    * 现在给出一个字符串表示若干位。返回最后一个字符是否必定为一位字符。给出的字符串总是以 0 结尾。
    * */

    public boolean isOneBitCharacter(int[] bits) {
        boolean isOneBitCharacter=true;
        for(int i=0;i<bits.length;i++){
            if(bits[i]==0){
                isOneBitCharacter=true;
            }else{
                isOneBitCharacter=false;
                i++;
            }
        }
        return isOneBitCharacter;
        // Write your code here
    }
}
