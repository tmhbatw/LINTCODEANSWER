package LINTCODE7;

import java.util.*;

public class LINTCODE657 {
    /*Description
    *设计一个数据结构实现在平均 O(1) 的复杂度下执行以下所有的操作。
    * insert(val): 如果这个元素不在set中，则插入。
    * remove(val): 如果这个元素在set中，则从set中移除。
    * getRandom: 随机从set中返回一个元素。每一个元素返回的可能性必须相同。
    * */

    class RandomizedSet {
        int [] num;
        int index;
        Map<Integer,Integer> set;
        public RandomizedSet() {
            this.num=new int[10000];
            this.index=0;
            this.set=new HashMap<>();
            // do intialization if necessary
        }

        /*
         * @param val: a value to the set
         * @return: true if the set did not already contain the specified element or false
         */
        public boolean insert(int val) {
            if(set.containsKey(val))
                return false;
            num[index]=val;
            set.put(val,index++);

            return true;
            // write your code here
        }

        /*
         * @param val: a value from the set
         * @return: true if the set contained the specified element or false
         */
        public boolean remove(int val) {
            if(!set.containsKey(val))
                return false;
            int curIndex=set.get(val);
            num[curIndex]=num[index--];
            set.put(num[curIndex],curIndex);
            set.remove(val);
            return true;
            // write your code here
        }

        /*
         * @return: Get a random element from the set
         */
        public int getRandom() {
            Random r = new Random();
            int cur= r.nextInt(set.size());
            return num[cur];
            // write your code here
        }
    }

    public static void main(String[] args)
    {
        Random r = new Random();
        for(int i=0 ; i<500 ;  i++) {
            int ran1 = r.nextInt(100);
            System.out.println(ran1);
        }
    }




}
