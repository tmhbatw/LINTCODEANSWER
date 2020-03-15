package LINTCODE16;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1573 {
    /*Description
    * 给定一个只包含大写字母的字符串S, 在S中插入尽量少的字符'_'，使同一种字母间隔至少为k，如果有多种插入方式，则选择目标字符串字典序最小的方式。
    * 例如S=”AABACCDCD”,k = 3,则目标字符串为”A__AB_AC__CD_CD”。由于目标字符串长度可能很长,我们只需要返回原串每个位置前插入的'_'的个数即可，比如前面的例子返回[0,2,0,1,0,2,0,1,0]。
    * （'_'的字典序是大于'Z'的）
    * */

    public int[] getAns(int k, String S) {
        int[] result=new int[S.length()];
        Map<Character,Integer> map=new HashMap<>();
        int curIndex=-1;
        for(int i=0;i<S.length();i++){
            curIndex++;
            char cur=S.charAt(i);
            if(!map.containsKey(cur)){
                result[i]=0;
            }else{
                int last=map.get(cur);
                if(curIndex-last>=k){
                    result[i]=0;
                }else{
                    result[i]=k-(curIndex-last);
                    curIndex+=result[i];
                }
            }
            map.put(cur,curIndex);
        }
        return result;
        // Write your code here.
    }
}
