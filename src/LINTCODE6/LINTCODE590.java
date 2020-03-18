package LINTCODE6;

public class LINTCODE590 {
    /*Description
    * 给一个图中的 n 个节点, 记为 1 到 n .在开始的时候图中没有边.
    * 你需要完成下面两个方法：
    * connect(a, b), 添加一条连接节点 a, b的边
    * query(a), 返回图中含 a 的联通区域内节点个数
    * */

    class ConnectingGraph2 {
        /*
         * @param n: An integer
         */
        int[] dp;
        int[] num;
        public ConnectingGraph2(int n) {
            dp=new int[n+1];
            num=new int[n+1];
            for(int i=1;i<=n;i++){
                dp[i]=i;
                num[i]=1;
            }
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
            int typeA=getType(a),typeB=getType(b);
            if(typeA!=typeB){
                dp[typeB]=typeA;
                num[typeA]+=num[typeB];
            }
            // write your code here
        }

        private int getType(int index){
            if(dp[index]==index)
                return index;
            return getType(dp[index]);
        }

        /*
         * @param a: An integer
         * @return: An integer
         */
        public int query(int a) {
            return num[getType(a)];
            // write your code here
        }
    }
}
