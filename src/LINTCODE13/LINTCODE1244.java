package LINTCODE13;

import java.util.*;

public class LINTCODE1244 {
    /*Description
    * 基因序列可以用8个字符的字符串表示，可选择的字符包括 "A", "C", "G", "T"。
    * 假设我们需要调查基因突变（从“起始点”到“结束点”突变），其中一个突变被定义为基因序列中的单个字符发生突变。
    * 例如，"AACCGGTT" -> "AACCGGTA"是1个突变。
    * 此外，还有一个给定的基因“库”，它记录了所有有效的基因突变。 基因必须在基因库中才有效。
    * 现在，给出3个参数 - 起始点，结束点，基因库，你的任务是确定从“起始点”到“结束点”变异所需的最小突变数。
    * 如果没有这样的突变，则返回-1。
    * */

    public int minMutation(String start, String end, String[] bank) {
        Map<String, List<String>> map=new HashMap<>();
        int length=bank.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(isMatch(bank[i],bank[j])){
                    map.putIfAbsent(bank[i],new ArrayList<>());
                    map.putIfAbsent(bank[j],new ArrayList<>());
                    map.get(bank[i]).add(bank[j]);
                    map.get(bank[j]).add(bank[i]);
                }
            }
        }
        if(start.equals(end))
            return 0;
        Map<String,Boolean> reached=new HashMap<>();
        for(String cur:bank)
            reached.put(cur,false);
        Queue<String> q=new LinkedList<>();
        for(int i=0;i<length;i++){
            if(isMatch(start,bank[i])){
                q.add(bank[i]);
                reached.put(bank[i],true);
            }
        }
        int step=1;
        while(!q.isEmpty()){
            int size=q.size();
            //System.out.println(q);
            for(int i=0;i<size;i++){
                String cur=q.poll();
                if(cur.equals(end))
                    return step;
                List<String> list=map.getOrDefault(cur,new ArrayList<>());
                //æSystem.out.println(list);
                for(String curr:list){
                    if(!reached.get(curr)){
                        q.add(curr);
                        reached.put(curr,true);
                    }
                }
            }
            step++;
        }
        return -1;
        // Write your code here
    }

    private boolean isMatch(String s1,String s2){
        int diffNumber = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diffNumber++;
                if(diffNumber>1)
                    return false;
            }
        }
        return true;
    }
}
