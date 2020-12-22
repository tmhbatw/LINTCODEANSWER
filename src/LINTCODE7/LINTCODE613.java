package LINTCODE7;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LINTCODE613 {
    /*Description
    * 每个学生有两个属性 id 和 scores。找到每个学生最高的5个分数的平均值。
    * */

    class Record {
        public int id, score;
        public Record(int id, int score){
            this.id = id;
            this.score = score;
        }
    }

    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, PriorityQueue<Integer>> map=new HashMap<>();
        for(Record cur:results){
            int id=cur.id;
            int score=cur.score;
            PriorityQueue<Integer> curQueue=map.getOrDefault(id,new PriorityQueue<>());
            curQueue.add(score);
            if(curQueue.size()>5)
                curQueue.poll();
            map.put(id,curQueue);
        }

        Map<Integer,Double> result=new HashMap<>();
        for(Map.Entry entry:map.entrySet()){
            int id= (int) entry.getKey();
            double res=0;
            PriorityQueue<Integer> curQueue= (PriorityQueue<Integer>) entry.getValue();
            while(!curQueue.isEmpty())
                res+=curQueue.poll();
            result.put(id,res/5);
        }
        return result;
        // Write your code here
    }
}
