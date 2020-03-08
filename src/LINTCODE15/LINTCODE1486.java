package LINTCODE15;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LINTCODE1486 {
    /*Description
    * 给定一系列的描述函数进入和退出的时间，问每个函数的运行时间是多长。
    * */

    public String[] getRuntime(String[] a) {
        HashMap<String,Integer> map=new HashMap<>();
        HashMap<String,Integer> res=new HashMap<>();
        for(String cur:a){
            String[] message=cur.split(" ");
            if(message[1].equals("Enter")){
                map.put(message[0],Integer.parseInt(message[2]));
            }else{
                int time=Integer.parseInt(message[2])-map.get(message[0]);
                res.put(message[0],res.getOrDefault(message[0],0)+time);
            }
        }
        PriorityQueue<Map.Entry> queue=new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                String oo1=(String)o1.getKey();
                String oo2=(String)o2.getKey();
                return oo1.compareTo(oo2);
            }
        });
        for(Map.Entry entry:res.entrySet())
            queue.add(entry);
        String[] result=new String[queue.size()];
        for(int i=0;i<result.length;i++){
            Map.Entry entry=queue.poll();
            result[i]=entry.getKey()+"|"+entry.getValue();
        }
        return result;
        // Write your code here
    }
}
