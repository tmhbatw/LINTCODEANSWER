package LINTCODE6;

import java.util.*;

public class LINTCODE554 {
    /*Description
    * 通过Map Reduce框架对整数进行排序
    * 在mapper中， key为可以忽略的文档id， value是待排序的整数.
    * 在reducer中, 你可以指定什么是key或者value(取决于你是如何实现你的mapper类的).
    * 对于输出的reducer类, key可以是任意， 但value需要有序(顺序取决于你什么时候输出)
    * */


      class OutputCollector<K, V> {
          public void collect(K key, V value){};
          // Adds a key/value pair to the output buffer
      }

    static class Element {
        public int row, col, val;
        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static class Map {
        public void map(int _, List<Integer> value,
                        OutputCollector<String, List<Integer>> output) {
            Collections.sort(value);
            output.collect("key",value);
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
        }
    }

    public static class Reduce {
        public void reduce(String key, List<List<Integer>> values,
                           OutputCollector<String, List<Integer>> output) {
            if(values.size()==0) {
                output.collect(key, Collections.emptyList());
                return;
            }
            List<Integer> list=new ArrayList<>();
            PriorityQueue<Element> queue=new PriorityQueue<>(values.size(), new Comparator<Element>() {
                @Override
                public int compare(Element o1, Element o2) {
                    return o1.val-o2.val;
                }
            });
            for(int i=0;i<values.size();i++){
                if(values.get(i).size()>0){
                    Element e=new Element(i,0,values.get(i).get(0));
                    queue.add(e);
                }
            }
            while (!queue.isEmpty()) {
                Element elem = queue.poll();
                list.add(elem.val);
                if (elem.col + 1 < values.get(elem.row).size()) {
                    elem.col += 1;
                    elem.val = values.get(elem.row).get(elem.col);
                    queue.add(elem);
                }
            }
            output.collect(key,list);
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
        }
    }
}
