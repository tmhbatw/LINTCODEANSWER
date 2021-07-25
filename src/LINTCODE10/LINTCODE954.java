package LINTCODE10;

import java.util.*;

public class LINTCODE954 {
    /*Description
    * 设计一个数据结构，需要支持以下操作，且平均时间复杂度为 O(1)。
    * */

    class RandomizedCollection {

        List<Integer> list;
        Map<Integer, Set<Integer>> map;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            this.list=new ArrayList<>();
            this.map=new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean exist=map.containsKey(val);
            if(!exist){
                map.put(val,new HashSet<>());
            }
            map.get(val).add(list.size());
            list.add(val);
            return !exist;
            // write your code here
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))
                return false;
            Set<Integer> list1=map.get(val);
            int removeIndex = list1.iterator().next();
            list1.remove(removeIndex);
            if(list1.size()==0)
                map.remove(val);
            if(removeIndex==list.size()-1){
                list.remove(removeIndex);
                return true;
            }
            int lastVal=list.get(list.size()-1);
            list.set(removeIndex, lastVal);
            list.remove(list.size()-1);
            Set<Integer> lastValSet=map.get(lastVal);
            lastValSet.remove(list.size());
            lastValSet.add(removeIndex);
            return true;
            // write your code here
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int index= (int) (Math.random()*list.size());
            return list.get(index);
            // write your code here
        }
    }
}
