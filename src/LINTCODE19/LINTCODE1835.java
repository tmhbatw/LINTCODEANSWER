package LINTCODE19;

public class LINTCODE1835 {
    /*Description
    * 有一个长度为 arrLenarrLen 的数组，开始有一个指针在索引 00 处。
    * 每一步操作中，你可以将指针向左或向右移动 11 步，或者停在原地（指针不能被移动到数组范围外）。
    * 给你两个整数 stepssteps 和 arrLenarrLen ，请你计算并返回：在恰好执行 stepssteps 次操作以后，指针仍然指向索引 00 处的方案数。
    * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
    * */

    public int numWays(int steps, int arrLen) {
        return recursion(steps,0,arrLen);
        // write your code here
    }

    private int recursion(int left,int cur,int arrLen){
        if(cur<0||cur>=arrLen)
            return 0;
        if(cur>left)
            return 0;
        if(left==0)
            return cur==0?1:0;
        return (recursion(left-1,cur-1,arrLen)+recursion(left-1,cur+1,arrLen)+recursion(left-1,cur,arrLen))%1000000007;
    }
}
