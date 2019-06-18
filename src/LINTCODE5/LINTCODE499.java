package LINTCODE5;

import java.util.Iterator;

public class LINTCODE499 {
    /*Description
    * Using map reduce to count word frequency.
    * */

    /*Solution
    *实现一个统计计算功能即可
    * */
      class OutputCollector<K, V> {
      public void collect(K key, V value){};
          // Adds a key/value pair to the output buffer
          }
    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            String[] val=value.split(" ");
            for(String v:val){
                output.collect(v,1);
            }
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            int sum=0;
            while(values.hasNext()){
                sum+=values.next();
            }
            output.collect(key,sum);
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
        }
    }
}
