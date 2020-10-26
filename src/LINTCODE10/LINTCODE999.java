package LINTCODE10;

public class LINTCODE999 {
    /*Description
    * 用循环数组来实现双端队列。你需要支持下列方法：
    * CircularDeque(n): 初始化一个大小为n的循环数组来存储元素
    * boolean isFull(): 如果数组满了就返回 true
    * boolean isEmpty(): 如果数组为空则返回 true
    * void pushFront(element): 往队列的头部添加一个元素
    * int popFront(): 从队列的头部弹出一个元素
    * void pushBack(element): 往队列的尾部添加一个元素
    * int popBack(): 从队列的尾部弹出一个元素
    * */

    class CircularDeque {
        int[] nums;  //用来存储元素
        int num;     //用来存储容器中元素的个数
        int i;       //容器的起始index
        int j;       //容器的结束index
        int capacity; //容器的容量

        public CircularDeque(int n) {
            nums = new int[n];
            num = 0;
            i = 0;
            j = 1;
            capacity = n;
        }
        // initialize your data structure here

        /**
         * @return: return true if the array is full
         */
        public boolean isFull() {
            return capacity==num;
            // write your code here
        }

        /**
         * @return: return true if there is no element in the array
         */
        public boolean isEmpty() {
            return num==0;
            // write your code here
        }

        /**
         * @param element: the element given to be added
         * @return: nothing
         */
        public void pushFront(int element) {
            num++;
            nums[i]=element;
            i=(i-1+capacity)%capacity;
            // write your code here
        }

        /**
         * @return: pop an element from the front of deque
         */
        public int popFront() {
            num--;
            i++;
            if(i==capacity)
                i=0;
            return nums[i];
            // write your code here
        }

        /**
         * @param element: element: the element given to be added
         * @return: nothing
         */
        public void pushBack(int element) {
            num++;
            nums[j++]=element;
            if(j==capacity)
                j=0;
            // write your code here
        }

        /**
         * @return: pop an element from the tail of deque
         */
        public int popBack() {
            num--;
            j=(j-1+capacity)%capacity;
            return nums[j];
            // write your code here
        }
    }
}
