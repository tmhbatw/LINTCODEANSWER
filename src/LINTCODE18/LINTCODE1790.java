package LINTCODE18;

public class LINTCODE1790 {
    /*Description
    * 给出一个字符串(以字符数组形式给出)，一个右偏移和一个左偏移，根据给出的偏移量循环移动字符串。
    * (left offest表示字符串向左的偏移量，right offest表示字符串向右的偏移量，左偏移量和右偏移量计算得到总偏移量，在总偏移量处分成两段字符串并交换位置)。
    * */

    public String RotateString2(String str, int left, int right) {
        int length=str.length();
        int move=(left-right)%length;
        if(move>=0){
            return str.substring(move)+str.substring(0,move);
        }
        return str.substring(length-move)+str.substring(0,length-move);
        // write your code here
    }
}
