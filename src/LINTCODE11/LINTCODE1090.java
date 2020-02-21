package LINTCODE11;

import java.util.HashMap;
import java.util.HashSet;

public class LINTCODE1090 {
    /*Description
    *使用insert和sum方法实现MapSum类。
    * 对于方法insert，您将获得一对（字符串，整数）。 字符串表示键，整数表示值。 如果键已存在，则原始键值对将被新键值对覆盖。
    * 对于方法sum，您将获得一个表示前缀的字符串，您需要返回所有以该前缀开头的所有键的值的总和。
    * */

     class MapSum {

        /** Initialize your data structure here. */
        HashMap<String,Integer> map;
        HashMap<String,Integer> list;
        public MapSum() {
            map=new HashMap<>();
            list=new HashMap<>();
        }

        public void insert(String key, int val) {
            if(list.containsKey(key)) {
                int curVal=list.get(key);
                for(int i=0;i<key.length();i++){
                    String cur=key.substring(0,i+1);
                    map.put(cur,map.get(cur)-curVal+val);
                }
                list.put(key,val);
                return;
            }
            list.put(key,val);
            for(int i=0;i<key.length();i++){
                String cur=key.substring(0,i+1);
                map.put(cur,map.getOrDefault(cur,0)+val);
            }
        }

        public int sum(String prefix) {
            return map.getOrDefault(prefix,0);
        }
    }
}
