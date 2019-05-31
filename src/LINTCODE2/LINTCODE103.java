package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE103 {

    /*
    *Given a linked list, return the node where the cycle begins.
    * */

    /*Solution
    *使用快慢两节点，快节点每次走2步，慢节点每次走一步
    * 通过对于题意的分析我们可以发现第一次相遇的地点距离循环开始的地方与头节点距离循环开始距离相等
    * 需要注意的是题目没有考虑第一次相遇快节点已经多饶了循坏路径k次的情况
    * */
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode fast=head;
        ListNode slow=head;
        /*        int step=0;*/
        while(true){
            if(fast==null||fast.next==null)
                return null;
            /*            step++;*/
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                break;
        }
        //它默认了相遇时快节点只走了一圈
//        int r=0;
//        while(true){
//            r++;
//            slow=slow.next;
//            if(fast==slow)
//                break;
//        }
        while(true){
            if(head==fast){
                return head;
            }
            head=head.next;
            fast=fast.next;

        }
//        int k=step/r;
//        System.out.println(step+"  "+r);
//        for(int i=0;i<step;i++)
//            head=head.next;
//        return head;
        // write your code here
    }
}
