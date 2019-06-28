package LINTCODE6;

import java.util.*;

public class LINTCODE503 {
    /*Description
    * Use Map Reduce to find anagrams in a given list of words.
    * */

    /*Solution
    *通过空格分解字符串获得目标字符串组并将字符串进行字典排序以及数据统计
    * */

      class OutputCollector<K, V> {
      public void collect(K key, V value){}
      };
          // Adds a key/value pair to the output buffer
          // }

    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
// Write your code here
// Output the results into output buffer.
// Ps. output.collect(String key, String value);
            String[] curr=value.split(",");
            for(String cur:curr){
                char[] c=cur.toCharArray();
                Arrays.sort(c);
                String currr=new String(c);
                output.collect(currr,cur);
            }
        }
    }
    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
// Write your code here
// Output the results into output buffer.
// Ps. output.collect(String key, List<String> value);
            List<String> results = new ArrayList<String>();
            while (values.hasNext()) {
                results.add(values.next());
            }
            output.collect(key, results);
        }
    }
}
