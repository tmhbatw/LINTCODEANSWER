package LINTCODE3;

public class LINTCODE288{
    /*Description
    * 你的任务是设计一个数据结构来存放一系列的数字，并且支持以下两种操作：
    * add(element)在数据结构中增加一个整数 element。getSum()
    * 对数据结构中的整数求和。
    * */

    public class MyContainer {
        /**
         * @param element: Add element into this container.
         * @return: nothing
         */
        int result=0;
        public void add(int element) {
            result+=element;
            // write your code here.
        }

        /**
         * @return: Sum of integers.
         */
        public int getSum() {
            return result;
            // write your code here.
        }
    }
}
