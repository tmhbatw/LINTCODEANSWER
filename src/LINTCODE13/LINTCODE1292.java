package LINTCODE13;

import datastructure.ListNode;

public class LINTCODE1292 {
    /*Description
    * 给定单链表，将所有奇数节点连接在一起，然后将偶数节点连接在一起。 请注意，这里我们讨论的是节点编号，而不是节点中的值。
    * */

    public ListNode oddEvenList(ListNode head) {
        boolean isOdd=true;
        ListNode OddStart=new ListNode(0);
        ListNode Odd=OddStart;
        ListNode EvenStart=new ListNode(0);
        ListNode Even=EvenStart;
        while(head!=null){
            if(isOdd){
                Odd.next=head;
                Odd=Odd.next;
            }else{
                Even.next=head;
                Even=Even.next;
            }
            head=head.next;
            isOdd=!isOdd;
        }
        Odd.next=EvenStart.next;
        Even.next=null;
        return OddStart.next;
           // write your code here
    }
}
