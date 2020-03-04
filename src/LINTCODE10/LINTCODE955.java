package LINTCODE10;

public class LINTCODE955 {
    /*Description
    * 用循环数组来实现队列。你需要支持下列方法：
    * CircularQueue(n): 初始化一个大小为n的循环数组来存储元素
    * boolean isFull(): 如果数组满了就返回 true
    * boolean isEmpty(): 如果数组为空则返回 true
    * void enqueue(element): 往队列中添加一个元素
    * int dequeue(): 从队列中弹出一个元素
    * */

    class CircularQueue {
        int[] num;
        int capacity;
        int start=0;
        int end=0;
        int number;
        public CircularQueue(int n) {
            num=new int[n];
            capacity=n;
            number=0;
            // initialize your data structure here
        }
        /**
         * @return:  return true if the array is full
         */
        public boolean isFull() {
            return number==capacity;
            // write your code here
        }

        /**
         * @return: return true if there is no element in the array
         */
        public boolean isEmpty() {
            return number==0;
            // write your code here
        }

        /**
         * @param element: the element given to be added
         * @return: nothing
         */
        public void enqueue(int element) {
            number++;
            num[end++]=element;
            if(end==capacity)
                end=0;
            // write your code here
        }

        /**
         * @return: pop an element from the queue
         */
        public int dequeue() {
            number--;
            if(start==capacity)
                start=0;
            return num[start++];
            // write your code here
        }
    }
}
