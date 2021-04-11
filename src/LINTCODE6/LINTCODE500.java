package LINTCODE6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE500 {
    /*Description
    * 创建给定文档的反向索引
    * */
    class Document {
        public int id;
        public String content;
    }

    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        Map<String,List<Integer>> map=new HashMap<>();
        for(Document cur:docs){
            String[] s=cur.content.split(" ");
            int id=cur.id;
            for(String curr:s){
                if(!map.containsKey(curr))
                    map.put(curr,new ArrayList<>());
                List<Integer> list=map.get(curr);
                if(list.isEmpty()||list.get(list.size()-1)!=id)
                    list.add(id);
            }
        }
        map.remove("");
        return map;
        // Write your code here
    }
}
