package LINTCODE12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LINTCODE1116 {
    /*Description
    * 给定一个不可中断单线程CPU的n个函数的运行日志，返回这些函数的执行时间片。
    * 每个函数都有一个唯一的id，从0到n-1。一个函数可能会被递归调用或者被其他函数调用。
    * 日志是一串字符串，其格式为：function_id:start_or_end:timestamp。例如：0:start:0意味着函数0从时间片0开始时执行。
    * 0:end:0意味着函数0从时间片0末尾结束。
    * 函数的“独占时间”是指这个函数所花费的时间片，调用其他函数所花费的时间片不会被算入该函数的独占时间。
    * 按照函数id升序返回每一个函数的独占时间。
    * */

    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i,0);
        int curIndex=-1;
        int startTime=-1;
        Stack<Integer> stack=new Stack<>();
        for(String cur:logs){
            if(cur.contains("start")){
                String[] s=cur.split(":start:");
                int index=Integer.parseInt(s[0]);
                int time=Integer.parseInt(s[1]);
                if (curIndex != -1) {
                    map.put(curIndex, map.get(curIndex) + time - startTime);
                    stack.add(curIndex);
                }
                curIndex=index;
                startTime=time;
            }else{
                String[] s=cur.split(":end:");
                int index=Integer.parseInt(s[0]);
                int time=Integer.parseInt(s[1]);
                time++;
                map.put(curIndex,map.get(curIndex)+time-startTime);
                startTime=time;
                if(!stack.empty()){
                    curIndex=stack.pop();
                }else
                    curIndex=-1;
            }
        }
        int[] result=new int[n];
        for(int i=0;i<n;i++)
            result[i]=map.get(i);
        return result;
        // write your code here
    }
}
