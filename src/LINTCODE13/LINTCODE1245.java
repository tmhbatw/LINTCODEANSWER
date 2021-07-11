package LINTCODE13;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE1245 {
    public class AllOne{
        class Bucket{
            int val;
            String key;
            Bucket pre;
            Bucket next;
            public Bucket(int val){
                this.val=val;
            }
            public Bucket(int val,String key){
                this.val=val;
                this.key = key;
            }
        }
        /**
         * @param key: the element given to be added
         * @return: nothing
         */
        /** Initialize your data structure here. */
        Bucket head;
        Bucket tail;
        Map<String, Bucket> map;
        public AllOne() {
            head = new Bucket(Integer.MIN_VALUE);
            tail = new Bucket(Integer.MAX_VALUE);
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
        }

        public void inc(String key) {
            if(!map.containsKey(key)){
                Bucket b =new Bucket(1, key);
                map.put(key, b);
                Bucket cur= head;
                while(cur.next.val==1&&cur.next.key.compareTo(key)<0)
                    cur=cur.next;
                Bucket next=cur.next;
                cur.next=b;
                b.pre = cur;
                b.next=next;
                next.pre = b;
                return;
            }
            Bucket b=map.get(key);
            b.val +=1;
            Bucket pre = b.pre;
            pre.next=b.next;
            b.next.pre = pre;
            while(pre.next.val<b.val||pre.next.val==b.val&&pre.next.key.compareTo(key)<0)
                pre=pre.next;
            Bucket next=pre.next;
            pre.next=b;
            next.pre=b;
            b.pre=pre;
            b.next=next;
            printBucket();
            // write your code here
        }

        private void printBucket(){
            Bucket first = head;
            while(first.next.val!=Integer.MAX_VALUE){
                first = first.next;
                System.out.print(first.val+" "+first.key+"   ");
            }
            System.out.println();
        }


        /**
         * @param key: pop an element from the queue
         * @return: nothing
         */
        public void dec(String key) {
            if(!map.containsKey(key))
                return;
            Bucket b=map.get(key);
            b.pre.next=b.next;
            b.next.pre=b.pre;
            b.val -=1;
            if(b.val==0) {
                map.remove(key);
                return;
            }
            Bucket next = b.next;
            while(next.pre.val>b.val||next.pre.val==b.val&&next.pre.key.compareTo(key)>0)
                next = next.pre;
            Bucket pre =next.pre;
            pre.next=b;
            b.pre = pre;
            b.next=next;
            next.pre = b;
            printBucket();
            // write your code here
        }

        /**
         * @return: nothing
         */
        public String getMaxKey() {
            if(tail.pre.val==Integer.MIN_VALUE)
                return "";
            Bucket cur=tail;
            int val =cur.pre.val;
            while(cur.pre.val==val)
                cur=cur.pre;
            return cur.key;
            // write your code here
        }

        /**
         * @return: nothing
         */
        public String getMinKey() {
            if(head.next.val == Integer.MAX_VALUE)
                return "";
            return head.next.key;
            // write your code here
        }
    }

}
