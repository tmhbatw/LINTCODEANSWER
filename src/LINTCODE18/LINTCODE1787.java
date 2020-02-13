package LINTCODE18;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LINTCODE1787 {
    /*Description
    * 使用map reduce 框架查找输入中的所有前缀及其所属单词和出现次数。
    * mapper的key为单词, value 为单词出现的次数，文档中的内容由空格分割
    * reducer应该所有的前缀，每个前缀包含最多为10个的key-value对（单词以及对应出现的次数）。
    * 如果小于10个则输出全部结果，大于10个则输出字典序前10个结果
    * */

      static class OutputCollector<K, V> {
          public void collect(K key, V value){};
          // Adds a key/value pair to the output buffer
      }

      static class Document {
          public int count;
          public String content;
      }

static class Pair {
    private String content;
    private int count;

            Pair(String key, int value) {
        this.content = key;
        this.count = value;
    }   public String getContent(){
 	 	 return this.content;
 	 }
 	public int getCount(){
    	 return this.count;
 }
}



    public static class Map {
        public void map(Document value,
                        OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String content = value.content;
            String words = "";
            Pair pair = new Pair(content,value.count);
            for(int i = 0;i < content.length();i++){
                words += content.charAt(i);
                output.collect(words,pair);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Pair> values, OutputCollector<String, Pair> output) {
            PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
                public int compare(Pair left, Pair right) {
                    if (left.getCount() != right.getCount()) {
                        return left.getCount() - right.getCount();
                    }
                    return right.getContent().compareTo(left.getContent());
                }
            });
            ArrayList<Pair> list = new ArrayList<Pair>();
            while (values.hasNext()) {
                queue.add(values.next());
                if(queue.size() > 10) queue.poll();
            }
            while(!queue.isEmpty()){
                list.add(queue.poll());
            }
            int n = list.size();
            for(int i = n - 1;i >= 0;i--)
                output.collect(key,list.get(i));
        }
    }
}
