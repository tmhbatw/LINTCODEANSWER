package LINTCODE6;

public class LINTCODE589 {
    /*Description
    * 给一个图中的n个节点, 记为 1 到 n . 在开始的时候图中没有边。
    * 你需要完成下面两个方法:
    * connect(a, b), 添加连接节点 a, b 的边.
    * query(a, b), 检验两个节点是否联通
    * */

    class ConnectingGraph {
        /*
         * @param n: An integer
         */
        int[] dp;
        public ConnectingGraph(int n) {
            dp=new int[n+1];
            for(int i=1;i<=n;i++)
                dp[i]=i;
            // do intialization if necessary
        }

        /*
         * @param a: An integer
         * @param b: An integer
         * @return: nothing
         */
        public void connect(int a, int b) {
            if(a>b){
                int temp=b;
                b=a;
                a=temp;
            }
            dp[getType(b)]=getType(a);
            // write your code here
        }

        private int getType(int index){
            if(dp[index]==index)
                return index;
            return getType(dp[index]);
        }

        /*
         * @param a: An integer
         * @param b: An integer
         * @return: A boolean
         */
        public boolean query(int a, int b) {
            return getType(a)==getType(b);
            // write your code here
        }
    }
}
