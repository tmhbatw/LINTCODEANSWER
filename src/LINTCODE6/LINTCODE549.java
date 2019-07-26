package LINTCODE6;

import java.util.*;

public class LINTCODE549 {

     // Definition of OutputCollector:
     class OutputCollector<K, V> {
         public void collect(K key, V value){};
                 // Adds a key/value pair to the output buffer
     }
     //Definition of Document:
     class Document {
         public int id;
         public String content;
     }

     //定义一个数据结构Pair
     static class Pair{
         String key;
         int value;

         public Pair(String s,int v){
             this.key=s;
             this.value=v;
         }
     }

        public static class Map {
            public void map(String _, Document value,
                            OutputCollector<String, Integer> output) {
                String content=value.content;
                String[] cont=content.split(" ");
                for(String cur:cont) {
                    if(cur.length()>=1) {
                        output.collect(cur, 1);
                    }
                }
                // Write your code here
                // Output the results into output buffer.
                // Ps. output.collect(String key, int value);
            }
        }

        public static class Reduce {
         private PriorityQueue<Pair> queue=null;
         private int k;


            public void setup(int k) {
                this.k=k;
                this.queue=new PriorityQueue<Pair>(new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        if(o1.value!=o2.value)
                            return o1.value-o2.value;
                        return o2.key.compareTo(o1.key);
                    }
                });
                // initialize your data structure here
            }

            public void reduce(String key, Iterator<Integer> values) {
                int sum=0;
                while(values.hasNext())
                    sum+=values.next();
                Pair pair=new Pair(key,sum);
                if(queue.size()<k)
                    queue.add(pair);
                else{
                    queue.add(pair);
                    queue.poll();
                }
                // Write your code here
            }

            public void cleanup(OutputCollector<String, Integer> output) {
                List<Pair> pairs=new ArrayList<>();
                while(!queue.isEmpty())
                    pairs.add(queue.poll());
                for(int i=k-1;i>=0;i--){
                    Pair cur=pairs.get(i);
                    output.collect(cur.key,cur.value);
                }
                // Output the top k pairs <word, times> into output buffer.
                // Ps. output.collect(String key, Integer value);
            }
        }

}
