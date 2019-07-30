package LINTCODE7;

import java.util.HashMap;

public class LINTCODE607 {
    /*Description
    * 设计b并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
    * add -把这个数添加到内部的数据结构。
    * find -是否存在任意一对数字之和等于这个值
    * */

    class TwoSum {

        HashMap<Integer,Integer> map=new HashMap<>();

        /**
         * @param number: An integer
         * @return: nothing
         */
        public void add(int number) {
            if(map.containsKey(number))
                map.put(number,2);
            else
                map.put(number,1);
            // write your code here
        }

        /**
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for(HashMap.Entry entry:map.entrySet()){
                int cur= (int) entry.getKey();
                if(cur+cur==value&&(int)entry.getValue()==2||map.containsKey(value-cur))
                    return true;
            }
            return false;
            // write your code here
        }
    }
}
