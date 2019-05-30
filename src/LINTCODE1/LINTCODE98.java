package LINTCODE1;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE98 {
    /*Description
    * Sort a linked list in O(n log n) time using constant space complexity.
    * */

    /*Solution
    * 使用赖皮方法将链表中的值排序输出
    * */

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        ListNode result=new ListNode(0);
        ListNode curr=result;
        for(int i=0;i<list.size();i++){
            curr.next=new ListNode(list.get(i));
            curr=curr.next;
        }
        return result.next;

        // write your code here
    }
    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(4);
        Collections.sort(list);
        System.out.println(list);
    }
}
