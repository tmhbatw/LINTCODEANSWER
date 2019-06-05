package LINTCODE2;

public class LINTCODE187 {
    /*Description
    * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。
    * 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
    * 求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
    * */

    /*Solution
    * 使用两个变量total以及part,其中total用来保存油总量是否大于消耗
    * part变量用来保存从起点到当前点总量减去损耗的差值
    * 假设从第i个节点开始出发，到底k个节点part值为负，因为我们直到从第i个节点到第i+1个节点肯定是非负的
    * 因此，从第i+1个节点开始，到第k个节点一定也是负的，因此i+1也不能成为开始
    * 因此下一个判断是否能出发的点应该是第k+1个节点
    * */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int part=0;
        int total=0;
        int index=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            part+=gas[i]-cost[i];
            if(part<0){
                part=0;
                index=i+1;
            }
        }
        if(total<0)
            return -1;
        return index;
        // write your code here
    }
}
