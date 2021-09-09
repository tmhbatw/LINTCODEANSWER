package LINTCODE13;

import java.util.*;

public class LINTCODE1289 {
    /*Description
    * 给定化学式（以字符串形式给出），返回每个原子的数量。
    * 原子始终以大写字符开头，然后以零或多个小写字母，表示名称。
    * 1个或多个数字代表元素数。如果元素数为1，则后面不会出现数字。 例如，H2O和H2O2是可能的，但H1O2是不可能的。
    * 连接在一起的两个化学式产生另一个化学式。 例如，H2O2He3Mg4也是一种配方。
    * 放在括号中的化学式和计数（可选）也是公式。 例如，(H2O2) 和(H2O2)3是化学式。
    * 给定一个化学式，将所有元素的计数，用以下形式的字符串输出：第一，名称（按排序顺序），
    * 后跟其计数（如果该计数大于1），后跟第二个名称（按排序顺序） ），然后是计数（如果该计数大于1），依此类推。
    * */

    public String countOfAtoms(String formula) {
        Set<String> q=new HashSet<>();
        Map<String, Integer> map=new HashMap<>();
        int length=formula.length();
        Stack<Map<String,Integer>> s=new Stack<>();
        for(int i=0;i<length;i++){
            char cur=formula.charAt(i);
            if(cur=='('){
                Map<String,Integer> curMap=new HashMap<>();
                s.add(curMap);
            }else if(cur==')'){
                int time=0;
                while(i<length-1&&formula.charAt(i+1)<='9'&&formula.charAt(i+1)>='0'){
                    time=time*10+formula.charAt(++i)-'0';
                }
                time=time==0?1:time;
                Map<String,Integer> curMap=s.pop();
                System.out.println(curMap);
                Map<String,Integer> add=s.isEmpty()?map:s.peek();
                for(Map.Entry<String,Integer> entry:curMap.entrySet()){
                    add.put(entry.getKey(),add.getOrDefault(entry.getKey(),0)+entry.getValue()*time);
                }
            }else if(cur<='Z'&&cur>='A'){
                String curr=cur+"";
                while(i<length-1&&formula.charAt(i+1)<='z'&&formula.charAt(i+1)>='a'){
                    curr+=formula.charAt(++i);
                }
                q.add(curr);
                int time=0;
                while(i<length-1&&formula.charAt(i+1)<='9'&&formula.charAt(i+1)>='0'){
                    time=time*10+formula.charAt(++i)-'0';
                }
                time=time==0?1:time;
                Map<String,Integer> add=s.isEmpty()?map:s.peek();
                add.put(curr,add.getOrDefault(curr,0)+time);
            }else{
                int time=formula.charAt(i)-'0';
                while(i<length-1&&formula.charAt(i+1)<='9'&&formula.charAt(i+1)>='0'){
                    time=time*10+formula.charAt(++i)-'0';
                }
                Map<String,Integer> curMap=s.pop();
                Map<String,Integer> add=s.isEmpty()?map:s.peek();
                for(Map.Entry<String,Integer> entry:curMap.entrySet()){
                    add.put(entry.getKey(),add.getOrDefault(entry.getKey(),0)+entry.getValue()*time);
                }
            }
        }
        List<String> l=new ArrayList<>(q);
        Collections.sort(l);
        StringBuilder sb=new StringBuilder();
        for(String cur:l){
            sb.append(cur);
            if(map.get(cur)>1){
                sb.append(map.get(cur));
            }
        }
        return sb.toString();
        // write your code here
    }
}
