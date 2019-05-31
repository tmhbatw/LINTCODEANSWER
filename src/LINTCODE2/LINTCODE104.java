package LINTCODE2;

import datastructure.ListNode;

import java.util.List;

public class LINTCODE104 {
    /*Description
    * Merge k sorted linked lists and return it as one sorted list.
    * Analyze and describe its complexity.
    * */

    /*Solution
    * 获取list中最小的节点加入到结果链表中即可
    * 时间复杂度为O(lists.size()*n);
    * */
    public ListNode mergeKLists(List<ListNode> lists) {
        remove(lists);
        ListNode result=new ListNode(0);
        ListNode curr=result;
        while(true){
            ListNode next=findMin(lists);
            if(next==null)
                break;
            curr.next=next;
            curr=curr.next;
        }
        return result.next;
        // write your code here
    }

    private ListNode findMin(List<ListNode> lists){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<lists.size();i++){
            index=min<=lists.get(i).val?index:i;
            min=Math.min(min,lists.get(i).val);
        }
        if(index==-1)
            return null;
        ListNode node=lists.get(index);
        ListNode result=node;
        node=node.next;
        if(node==null)
            lists.remove(index);
        else {
            lists.set(index, node);
        }
        return result;
    }

    private void remove(List<ListNode> list){
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i)==null)
                list.remove(i);
        }
    }
}
