package LINTCODE13;

import java.util.*;

public class LINTCODE1257 {
    /*Description
    * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。
    * 根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
    * */

    private class Node{
        String next;
        double val;
        public Node(String next,double val){
            this.next=next;
            this.val=val;
        }
    }
    private class Vertex{
        String name;
        double curRes;
        public Vertex(String name,double curRes){
            this.name=name;
            this.curRes=curRes;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> set=new HashSet<>();
        Map<String,List<Node>> map=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> cur=equations.get(i);
            set.addAll(cur);
            List<Node> list1=map.getOrDefault(cur.get(0),new ArrayList<Node>());
            list1.add(new Node(cur.get(1),values[i]));
            map.put(cur.get(0),list1);
            List<Node> list2=map.getOrDefault(cur.get(1),new ArrayList<Node>());
            list2.add(new Node(cur.get(0),1/values[i]));
            map.put(cur.get(1),list2);
        }
        double[] result=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String> list=queries.get(i);
            String from=list.get(0);
            String to=list.get(1);
            if(!set.contains(from)||!set.contains(to))
                result[i]=-1.0;
            else if(from.equals(to))
                result[i]=1.0;
            else{result[i]=getResult(from,to,map);}
        }
        return result;
        // write your code here
    }

    private double getResult(String from,String to,Map<String,List<Node>> map){
        HashSet<String> set=new HashSet<>();
        Queue<Vertex> queue=new LinkedList<>();
        set.add(from);
        queue.add(new Vertex(from,1.0));
        while(!queue.isEmpty()){
            Vertex cur=queue.poll();
            List<Node> list=map.get(cur.name);
            for(Node curNode:list){
                if(set.contains(curNode.next))
                    continue;
                if(curNode.next.equals(to))
                    return cur.curRes*curNode.val;
                set.add(curNode.next);
                queue.add(new Vertex(curNode.next,cur.curRes*curNode.val));
            }
        }
        return -1.0;
    }

}
