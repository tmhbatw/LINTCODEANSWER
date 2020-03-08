package LINTCODE9;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE830 {
    /*Description
    * 给出一个字符串，以 字符在串中出现的次数 为第一关键字，字典序为第二关键字排序字符串
    * */

    public String stringSort(String str) {
        int[] num=new int[26];
        for(int i=0;i<str.length();i++)
            num[str.charAt(i)-'a']++;
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o2[1]-o1[1];
            }
        });
        for(int i=0;i<num.length;i++)
            queue.add(new int[]{i,num[i]});
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int i=0;i<cur[1];i++)
                sb.append((char)(cur[0]+'a'));
        }
        return sb.toString();
        // Write your code here
    }
}
