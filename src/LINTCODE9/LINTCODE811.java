package LINTCODE9;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE811 {
    /*Description
    * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
    * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，
    * 请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
    * */


    public boolean canTransform(String start, String end) {
        int length=start.length();
        int sindex=0,eindex=0;
        while(sindex<length&&eindex<length){
            while(sindex<length&&start.charAt(sindex)=='X')
                sindex++;
            while(eindex<length&&end.charAt(eindex)=='X')
                eindex++;
            if(sindex==length&&eindex==length)
                return true;
            if(sindex==length||eindex==length||start.charAt(sindex)!=end.charAt(eindex))
                return false;
            if(start.charAt(sindex)=='L'&&sindex<eindex||start.charAt(sindex)=='R'&&sindex>eindex)
                return false;
            sindex++;
            eindex++;
        }
        return true;
        // Write your code here
    }
}
