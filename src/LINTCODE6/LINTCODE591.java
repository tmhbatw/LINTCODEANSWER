package LINTCODE6;

import java.util.Collections;

public class LINTCODE591 {
    /*Description
    * 给一个图中的 n 个节点, 记为 1 到 n . 在开始的时候图中没有边.
    * 你需要完成下面两个方法:
    * connect(a, b), 添加一条连接节点 a, b的边
    * query(), 返回图中联通区域个数
    * */


    class ConnectingGraph3 {

        int num;
        int[] nums;
        public ConnectingGraph3(int num){
            this.num=num;
            this.nums=new int[num+1];
            for(int i=0;i<num+1;i++){
                nums[i]=i;
            }
        }

        private int getType(int i){
            while(nums[i]!=i){
                i=nums[i];
            }
            return i;
        }

        /**
         * @param a: An integer
         * @param b: An integer
         * @return: nothing
         */

        public void connect(int a, int b) {
            int aa=getType((a));
            int bb=getType(b);
            if(aa!=bb){
                nums[bb]=aa;
                num--;
            }

            // write your code here
        }

        /**
         * @return: An integer
         */
        public int query() {
            return num;
            // write your code here
        }
    }
}
