package LINTCODE6;

import java.util.Iterator;

public class LINTCODE537 {

    /*Description
    *给出若干字符串和数字 N。用 Map Reduce 的方法统计所有 N-Grams 及其出现次数 。以字母为粒度。
    * */

    class OutputCollector<K, V> {
      public void collect(K key, V value){};
          // Adds a key/value pair to the output buffer
    }

    public static class Map {
        public void map(String s, int n, String str,
                        OutputCollector<String, Integer> output) {
            for(int i=0;i<str.length()-n+1;i++)
                output.collect(str.substring(i,i+n),1);
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Integer value);
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            int sum=0;
            while(values.hasNext())
                sum+=values.next();
            output.collect(key,sum);
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
        }
    }
}
