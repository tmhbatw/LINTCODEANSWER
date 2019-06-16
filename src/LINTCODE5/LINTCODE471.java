package LINTCODE5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LINTCODE471 {
    /*Description
    * Given a list of words and an integer k, return the top k frequent words in the list.
    * */

    /*Solution
    * 首先使用一个hashMap统计每个词出现的次数，然后通过小根堆判断获取出现频率较高的k个词语
    * */

    public String[] topKFrequentWords(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else
                map.put(words[i],1);
        }
        PriorityQueue<HashMap.Entry> queue=new PriorityQueue<>(new Comparator<HashMap.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                if(o1.getValue()==o2.getValue()){
                    String s1= (String) o1.getKey();
                    String s2=(String) o2.getKey();
                    return s2.compareTo(s1);
                }
                return (int)o1.getValue()-(int)o2.getValue();
            }
        });
        for(HashMap.Entry entry:map.entrySet()){
            queue.add(entry);
            if(queue.size()==(k+1))
                queue.poll();
        }
        String[] result=new String[k];
        for(int i=k-1;i>=0;i--){
            result[i]=(String)queue.poll().getKey();
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
        PriorityQueue<String> queue=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        queue.add("aa");
        queue.add("a");
        queue.add("b");
        System.out.println(queue);
    }



}
