package LINTCODE5;

import datastructure.ParentTreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE401 {
    /*Description
    * Find the kth smallest number in a row and column sorted matrix.
    * Each row and each column of the matrix is incremental.
    * */

    /*Solution
    * 可以创建一个小根堆，通过小根堆的排序逐个读出最小的数字直到第k个
    * */


    public int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0||matrix[0].length==0||k==0)
            return 0;
        PriorityQueue<Row> queue=new PriorityQueue<>(new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.nums[o1.index]-o2.nums[o2.index];
            }
        });
        for(int i=0;i<matrix.length;i++){
            queue.add(new Row(0,matrix[i]));
        }
        while(--k>0){
            Row curr=queue.poll();
            if(++curr.index<curr.nums.length)
                queue.add(curr);
        }
        return queue.peek().nums[queue.peek().index];
        // write your code here
    }

    class Row{
        int index;
        int[] nums;
        public Row(int index , int[] nums){
            this.index=index;
            this.nums=nums;
        }
    }
}
