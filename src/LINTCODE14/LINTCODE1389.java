package LINTCODE14;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1389 {
    /*Description
    * 给定字符串S和字符C，返回一个整数数组，表示字符串中每个字符与字符C的最短距离。
    * */

    public int[] shortestToChar(String S, char C) {
        int length=S.length();
        boolean[] reached=new boolean[length];
        int[] result=new int[length];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<length;i++){
            if(S.charAt(i)==C) {
                queue.add(i);
                reached[i]=true;
            }
        }
        int time=0;
        while(!queue.isEmpty()){
            time++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int cur=queue.poll();
                if(cur<length-1){
                    if(!reached[cur+1]){
                        reached[cur+1]=true;
                        result[cur+1]=time;
                        queue.add(cur+1);
                    }
                }
                if(cur>=1){
                    if(!reached[cur-1]){
                        reached[cur-1]=true;
                        result[cur-1]=time;
                        queue.add(cur-1);
                    }
                }
            }
        }
        return result;
        //
    }
}
