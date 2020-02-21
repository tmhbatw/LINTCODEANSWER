package LINTCODE11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1041 {
    /*Description
    * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
    * 若可行，输出任意可行的结果。若不可行，返回空字符串。
    * */

    public String reorganizeString(String S) {
        int[] time=new int[26];
        int length=S.length();
        for(int i=0;i<length;i++){
            time[S.charAt(i)-'a']++;
        }
        int half= (int) Math.ceil(1.0*length/2);
        for(int num:time)
            if(num>half)
                return "";
        PriorityQueue<int[]> maxQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for(int i=0;i<time.length;i++){
            int[] cur=new int[]{i,time[i]};
            maxQueue.add(cur);
        }
        StringBuilder sb=new StringBuilder();
        int index1=0;
        int curMax=0;
        int index2=0;
        int curMin=0;
        for(int i=0;i<length/2;i++){
            if(index1==0){
                int[] cur=maxQueue.poll();
                index1=cur[1];
                curMax=cur[0];
            }
            if(index2==0){
                int[] cur=maxQueue.poll();
                index2=cur[1];
                curMin=cur[0];
            }
            sb.append((char)(curMax+'a')).append((char)(curMin+'a'));
            index1--;
            index2--;
        }
        if(length%2==1){
            if(index1!=0)
                sb.append((char)(curMax+'a'));
            else
                sb.append((char)maxQueue.poll()[0]);
        }
        return sb.toString();
        // write your code here
    }
}
