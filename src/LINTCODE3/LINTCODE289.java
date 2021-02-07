package LINTCODE3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LINTCODE289 {
    /*Description
    * 你的任务是设计一个数据结构来存放一系列的数字，并且支持以下三种操作：
    * add(element)
    * 在数据结构中增加一个整数 element。若 element 已经存在于数据结构中，本次操作无效。
    * remove(element)
    * 在数据结构中删除一个整数 element。若 element 不存在于数据结构中，本次操作无效。
    * getSum()
    * 对数据结构中的整数求和。
    * */

    public class MyContainerII {
        int result;
        Set<Integer> map;
        public MyContainerII() {
            this.result=0;
            this.map=new HashSet<>();
            // initialize your data structure here
        }

        /**
         * @param element: Add element into this container.
         * @return: nothing
         */
        public void add(int element) {
            if(!map.contains(element)){
                result+=element;
                map.add(element);
            }
            // write your code here
        }

        /**
         * @param element: Remove element into this container.
         * @return: nothing
         */
        public void remove(int element) {
            if(map.contains(element)){
                map.remove(element);
                result-=element;
            }
            // write your code here
        }

        /**
         * @return: Sum of integers.
         */
        public int getSum() {
            return result;
            // write your code here
        }
    }
}
