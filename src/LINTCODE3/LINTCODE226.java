package LINTCODE3;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE226 {
    /*Description
    *假设有一堆盘子，叠的太高就可能会倒。所以在现实生活中，
    * 当盘子叠到一定高度，我们就会重新开始叠。
    * 实现这样的一个数据结构，我们称之为栈集，来模拟这个过程。
    * 这个栈集包含若干个栈（可以理解为若干堆的盘子），如果一个栈满了，
    * 就需要新建一个栈来装新加入的项。你需要实现栈集的两个方法，push(item) 和 pop()，
    * 让这个栈集对外表现得就像是一个栈在进行操作一样。
    * 另外，你还需要多实现一个popAt(index)的方法，该方法可以pop栈集中指定的栈的栈顶元素。
    * 并且，该方法执行后，除了最后一个栈可以不满以外，其他的栈仍然需要保持是满的。
    * */

    public class SetOfStacks2 {
        /*
         * @param capacity: an inetger, capacity of sub stack
         */
        class Node{
            int val;
            Node pre;
            Node next;
            public Node(int val){
                this.val = val;
                this.pre = null;
                this.next = null;
            }
        }
        List<Node> list;
        int capacity;
        Node head;
        Node end;
        int time;
        public SetOfStacks2(int capacity) {
            this.capacity = capacity;
            this.head= new Node(-1);
            this.end = new Node(-1);
            this.head.next=end;
            this.end.pre = head;
            this.list=new ArrayList<>();
            this.time =0;
            // do intialization if necessary
        }

        /*
         * @param v: An integer
         * @return: nothing
         */
        public void push(int v) {
            Node cur= new Node(v);
            Node pre=end.pre;
            pre.next=cur;
            cur.pre=pre;
            end.pre=cur;
            cur.next=end;
            time++;
            if(time%capacity==0){
                list.add(cur);
            }
            // write your code here
        }


        /*
         * @return: An integer
         */
        public int pop() {
            time--;
            Node remove=end.pre;
            if(list.size()>0&&remove==list.get(list.size()-1)){
                list.remove(list.size()-1);
            }
            end.pre=remove.pre;
            remove.pre.next=end;
            return remove.val;
            // write your code here
        }

        /*
         * @param index: The index of a specific sub-stack
         * @return: top element of the specific sub-stack
         */
        public int popAt(int index) {
            if(index==list.size()){
                return pop();
            }
            time--;
            Node remove = list.get(index);
            for(int i=index;i<list.size();i++){
                list.set(i,list.get(i).next);
            }
            if(list.get(list.size()-1)==end){
                list.remove(list.size()-1);
            }
            remove.pre.next=remove.next;
            remove.next.pre=remove.pre;
            return remove.val;
            // write your code here
        }
    }
}
