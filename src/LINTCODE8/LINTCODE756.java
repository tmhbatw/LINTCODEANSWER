package LINTCODE8;

import datastructure.ListNode;

public class LINTCODE756 {
    public long multiplyLists(ListNode l1, ListNode l2) {
        long n1=0,n2=0;
        while(l1!=null) {
            n1 = n1 * 10 + l1.val;
            l1=l1.next;
        }
        while(l2!=null){
            n2=n2*10+l2.val;
            l2=l2.next;
        }
        return n1*n2;
        // write your code here
    }
}
