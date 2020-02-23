package LINTCODE8;

import java.util.*;

public class LINTCODE790 {
    /*Description
    *符号串生成器由两部分组成，开始符号和生成规则集合，
    * 比如对于以下符号串生成器，
    * 开始符合：'S'，生成规则集合：["S -> abc", "S -> aA", "A -> b", "A -> c"]
    * 那么，符号串 abc 可以被生成，因为 S -> abc。
    * 符号串 ab 可以被生成，因为 S -> aA -> ab。
    * 符号串 ac 可以被生成，因为 S -> aA -> ac。
    * 现在，给你一个符号串生成器，一个符号串，若该符号串可以被生成返回 True，否则返回 False。
    * */

    boolean reached=false;
    int targetLength=0;
    String target="";
    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
        targetLength=symbolString.length();
        target=symbolString;
        Map<Character, List<String>> map=new HashMap<>();
        for(String cur:generator){
            String[] curr=cur.split(" -> ");
            char key=curr[0].charAt(0);
            List<String> value=map.getOrDefault(key,new ArrayList<>());
            value.add(curr[1]);
            map.put(key,value);
        }
        HashSet<String> set=new HashSet<>();
        recursion(map,set,""+startSymbol);
        return reached;
        // Write  your code here.
    }

    private void recursion(Map<Character,List<String>> map,HashSet<String> set,String cur){
        System.out.println(cur);
        if(reached||cur.length()>targetLength||set.contains(cur))
            return;
        if(cur.equals(target)){
            reached=true;
            return;
        }
        set.add(cur);
        for(int i=0;i<cur.length();i++){
            char curr=cur.charAt(i);
            if(map.containsKey(curr)){
                List<String> list=map.get(curr);
                for(String s:list){
                    recursion(map,set,cur.substring(0,i)+s+cur.substring(i+1));
                }
            }
        }
    }
}
