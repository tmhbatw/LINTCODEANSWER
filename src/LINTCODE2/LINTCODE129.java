package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE129 {
    /*Description
    * 哈希表容量的大小在一开始是不确定的。如果哈希表存储的元素太多（如超过容量的十分之一），我们应该将哈希表容量扩大一倍，并将所有的哈希值重新安排
    * */

    /*Solution
    * 创建一个大的哈希表将表中原有的值复制过来即可
    * */
    public ListNode[] rehashing(ListNode[] hashTable) {
        int capacity=hashTable.length*2;
        ListNode[] result=new ListNode[capacity];
        for(int i=0;i<hashTable.length;i++){
            ListNode curr=hashTable[i];
            while(curr!=null){
                int index=curr.val%capacity;
                ListNode to=result[index];
                if(to==null){
                    result[index]=curr;
                    break;
                }
                ListNode cur=to;
                while(cur.next!=null){
                    cur=cur.next;
                }
                cur.next=curr;
                cur.next.next=null;
                result[index]=to;
                curr=curr.next;
            }
        }
        return result;

        // write your code here
    }


    public static void main(String[] args){
        ListNode[] result=new ListNode[2];
        result[0]=new ListNode(3);
        ListNode to=result[0];
        ListNode cur=to;
        while(cur.next!=null){
            cur=cur.next;
        }
        ListNode haha=new ListNode(4);
        cur.next=haha;
        result[0]=to;
        System.out.println(result[0].next.val);
    }
}
