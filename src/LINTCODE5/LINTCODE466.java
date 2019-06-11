package LINTCODE5;

import datastructure.ListNode;

public class LINTCODE466 {
    /*Description
    * 计算多少个节点
    * */

    /*Solution
    * 循环遍历即可
    * */
    public int countNodes(ListNode head) {
        int result=0;
        while(head!=null){
            result++;
            head=head.next;
        }
        return result;
        // write your code here
    }
}
