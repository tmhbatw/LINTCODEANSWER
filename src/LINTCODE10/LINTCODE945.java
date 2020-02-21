package LINTCODE10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE945 {
    /*Description
    * 给定一个字符串，表示CPU需要执行的任务。 这个字符串由大写字母A到Z构成，不同的字母代表不同的任务。完成任务不需要按照给定的顺序。
    * 每项任务都可以在一个单位时间内被完成。 在每个单位时间，CPU可以选择完成一个任务或是不工作。
    * 但是，题目会给定一个非负的冷却时间“n”，表示在执行两个“相同的任务”之间，必须至少有n个单位时间，此时CPU不能执行该任务，只能执行其他任务或者不工作。
    * 您需要返回CPU完成所有给定任务所需的最少单位时间数。
    * */

    public int leastInterval(char[] tasks, int n) {
        Arrays.sort(tasks);
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<tasks.length;i++){
            char cur=tasks[i];
            int times=1;
            while(i<tasks.length-1&&tasks[i+1]==cur){
                times++;
                i++;
            }
            queue.add(times);
        }
        int[] time=new int[n+1];
        for(int i=0;i<n+1&&!queue.isEmpty();i++)
            time[i]=queue.poll();
        int result=0;
        while(true){
            if(queue.isEmpty())
                return result+getResult(time);
            for(int i=0;i<n+1;i++){
                time[i]--;
                if(time[i]==0){
                    time[i]=queue.isEmpty()?0:queue.poll();
                }
            }
            result+=n+1;
        }
        // write your code here
    }

    private int getResult(int[] num){
        int max=0;
        int maxTime=0;
        for(int cur:num){
            if(cur>max){
                max=cur;
                maxTime=1;
            }else if(cur==max)
                maxTime++;
        }
        return (max-1)*num.length+maxTime;
    }
}
