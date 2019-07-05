package LINTCODE3;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE217 {
    /*Description
    * 设计一种方法，从无序链表中删除重复项。
    * Challenge
    * 无额外空间
    * */

    /*Solution
    *可以每判断一个节点就遍历它前面的节点判断是否存在过
    * 也可以创建一个hashSet用来存储已经出现过的数字
    * */

    public ListNode removeDuplicates(ListNode head) {
        Set<Integer> set=new HashSet<>();
        ListNode curr=head;
        ListNode last=null;
        while(curr!=null){
            if(set.contains(curr.val)){
                last.next=curr.next;
                curr=curr.next;
            }else{
                set.add(curr.val);
                last=curr;
                curr=curr.next;
            }
        }
        return head;
        // write your code here
    }
}
