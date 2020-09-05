package LINTCODE4;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE318 {
    /*Description
    *给你两个字符串A和B，返回一个矩阵。串A要求从左往右输出，串B要求从上往下输出，两串交于一点（即有一个字母共用）。
    * 共用的字母要求是串A中第一个在串B也包含的字母，特别的，要求交点是两串中各自第一次出现共用的字母的位置。其余空白处要求用"."
    * 补齐（不包括引号）。比如当串A="ABBA"并且串B=“CCBB”。你需返回四行：
    * */

    public List<String> characterGrid(String A, String B) {
        int lengthA=A.length();
        int lengthB=B.length();
        List<String> result=new ArrayList<>();
        for(int i=0;i<lengthA;i++){
            char cur=A.charAt(i);
            for(int j=0;j<lengthB;j++){
                if (cur == B.charAt(j)){
                    StringBuilder pre=new StringBuilder();
                    for(int k=0;k<i;k++)
                        pre.append('.');
                    StringBuilder last=new StringBuilder();
                    for(int k=0;k<lengthA-1-i;k++)
                        last.append('.');
                    for(int k=0;k<lengthB;k++){
                        if(k==j)
                            result.add(A);
                        else
                            result.add(pre.toString()+B.charAt(k)+last.toString());
                    }
                    return result;
                }
            }
        }
        return result;
        // write your code here.
    }

}
