package LINTCODE12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1196 {

    public static void main(String[] args){
        String a="abc";
        String b="abcd";
        System.out.println(b.indexOf(a));
    }

    public int findRotateSteps(String ring, String key) {

        Map<Character, List<Integer>> map=new HashMap<>();
        for(int i=0;i<ring.length();i++){
            char cur=ring.charAt(i);
            map.putIfAbsent(cur,new ArrayList<>());
            map.get(cur).add(i);
        }

        Map<Integer,Integer> step=new HashMap<>();
        step.put(0,0);
        int length=ring.length();

        for(int j=0;j<key.length();j++){
            char cur=key.charAt(j);
            if(!map.containsKey(cur))
                return -1;
            List<Integer> list=map.get(cur);
            Map<Integer,Integer> curStep=new HashMap<>();
            for(int pos:list) {
                int s=Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> entry :step.entrySet()){
                    int index=entry.getKey();
                    s=Math.min(s,getDis(index,pos,length)+entry.getValue());
                }
                curStep.put(pos,s);
            }

            step=curStep;
        }

        int result=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry:step.entrySet()){
            result=Math.min(result,entry.getValue());
        }
        return result+key.length();
        // write your code here
    }

    private int getDis(int index1, int index2, int length){
        int min=Math.min(index1,index2), max=Math.max(index1,index2);
        return Math.min(max-min,min+length-max);
    }


}
