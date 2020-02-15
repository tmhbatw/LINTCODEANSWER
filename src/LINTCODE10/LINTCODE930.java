package LINTCODE10;

import datastructure.DoublyListNode;

import java.util.HashSet;

public class LINTCODE930 {
    /*Description
    * 给定一个双向链表和一个节点数组。如果节点彼此连接(这意味着我们可以通过其中任何一个节点访问任何节点)，
    * 那么我们可以将它们视为一个块。查找给定数组中的块数。
    * */

    public int blockNumber(DoublyListNode head, int[] nodes) {
        int size=nodes.length;
        int result=0;
        HashSet<Integer> set=new HashSet<>();
        for(int cur:nodes)
            set.add(cur);
        while(head!=null&&size!=0){
            if(set.contains(head.val)){
                result++;
                size--;
                head=head.next;
                while(head!=null&&set.contains(head.val)){
                    head=head.next;
                    size--;
                }
            }
            else{
                head=head.next;
            }
        }
        return result;
        // write your code here
    }
}
