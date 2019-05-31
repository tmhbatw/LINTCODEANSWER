package LINTCODE2;

import datastructure.RandomListNode;

public class LINTCODE105 {

    /*Description
    * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
    * */

    /*Solution
    * 简单的复制过程——不知题目难点在何
    * */

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode result=new RandomListNode(0);
        RandomListNode curr=result;
        while(head!=null){
            curr.next=new RandomListNode(head.label);
            if(head.random!=null)
                curr.random=new RandomListNode(head.random.label);
            curr=curr.next;
        }
        return result.next;
        // write your code here
    }

}
