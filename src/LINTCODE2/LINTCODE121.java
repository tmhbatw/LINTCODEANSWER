package LINTCODE2;

import java.util.*;

public class LINTCODE121 {

    /*Description
    *Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, output sequence in dictionary order.
    * Transformation rule such that:
    * Only one letter can be changed at a time
    * Each intermediate word must exist in the dictionary
    * */

    /*Solution
    * 与120题相似
    * 区别在于需要保存转换结果以及删除不需要的字符串需要在每一层遍历结束后进行
    * */

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        dict.remove(start);
        dict.add(end);
        List<List<String>> result=new ArrayList<>();
        List<String> res=new ArrayList<>();
        Deque<List<String>> stack=new ArrayDeque<>();
        res.add(start);
        stack.add(res);
        boolean judge=true;
        while(judge){
            int size=stack.size();
            Set<String> delete=new HashSet<>();
            for(;size>0;size--){

                List<String> lis=stack.pollLast();
                String cur=lis.get(lis.size()-1);

                for(String curr:dict){
                    if(change(curr,cur)) {
                        List<String> li=new ArrayList<>();
                        li.addAll(lis);
                        li.add(curr);
                        stack.push(li);
                        delete.add(curr);
                        if(curr.equals(end)){
                            result.add(li);
                            judge=false;
                        }
                    }
                }

            }
            for(String del:delete)
                dict.remove(del);
        }
        return result;
    }

    private boolean change(String curr,String s){
        int result=0;
        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i)!=s.charAt(i)) {
                result++;
            }
            if(result==2)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);
        set.remove(2);
        System.out.println(set);
    }
}
