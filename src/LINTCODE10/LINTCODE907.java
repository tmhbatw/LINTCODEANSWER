package LINTCODE10;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LINTCODE907 {
    /*Description
    *
    * */

    class Node {
        char c;
        int time;
        int index;
        public Node(char c,int time,int index){
            this.c=c;
            this.time=time;
        }
    }


    public String rearrangeString(String s, int k) {
        int length=s.length();
        Queue<Node> q=new PriorityQueue<>((o1,o2)->{
            return o2.time-o1.time;
        });
        Queue<Node> q2=new LinkedList<>();
        int[] time=new int[26];
        for(int i=0;i<length;i++){
            time[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(time[i]>0)
                q.add(new Node((char)(i+'a'),time[i],0));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<length;i++){
            if(!q2.isEmpty()&&q2.peek().index==i)
                q.add(q2.poll());
            if(q.isEmpty())
                return "";
            Node cur=q.poll();
            sb.append(cur.c);
            cur.time-=1;
            if(cur.time>=0) {
                cur.index=i+k;
                q2.add(cur);
            }
        }
        return sb.toString();
        // Write your code here
    }

}
