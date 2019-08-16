package LINTCODE8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE774 {
    /*Description
    * 所有的DNA由一系列缩写的核苷酸 A, C, G 和 T组成.
    * 比如; "ACGAATTCCG". 在研究 DNA 时, 有时候鉴别出 DNA 中的重复序列是很有用的.
    * 写一个函数来找到所有在 DNA 中出现超过一次且长度为 10个字母 的序列(子串).
    * */

    public List<String> findRepeatedDna(String s) {
        Map<String,Integer> map=new HashMap<>();
        List<String> result=new ArrayList<>();
        for(int i=0;i<s.length()-9;i++){
            String cur=s.substring(i,i+10);
            map.put(cur,map.getOrDefault(cur,0)+1);
            if(map.get(cur)==1){
                result.add(cur);
            }
        }
        return result;
        // write your code here
    }
}
