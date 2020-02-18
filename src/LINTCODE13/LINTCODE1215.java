package LINTCODE13;

public class LINTCODE1215 {
    /*Description
    * 一个神奇字符串S仅包含'1'和'2'，并遵守以下规则：
    * 字符串S是神奇的，因为连接字符'1'和'2'的连续出现次数会产生字符串S本身。
    * 字符串S的前几个元素如下：S = “1221121221221121122 ......”
    * 如果我们将S中的连续'1'和'2'分组，它将是：
    * 1 22 11 2 1 22 1 22 11 2 11 22 ......
    * 并且每组中出现'1'或'2'的情况是：
    * 1 2 2 1 1 2 1 2 2 1 2 2 ......
    * 您可以看到上面的出现序列是S本身。
    * 给定一个整数N作为输入，返回神奇字符串S中前N个数字中的'1'的个数。
    * */

    public int magicalString(int n) {
        if(n<=0)
            return 0;
        if(n<=3)
            return 1;
        int result=1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int index=3;
        boolean isOne=true;
        int time=2;
        for(int i=4;i<=n;i++){
            if(isOne) {
                dp[i] = 1;
                result++;
            }else
                dp[i]=2;
            time--;
            if(time==0){
                index++;
                time=dp[index];
                isOne= !isOne;
            }
        }
        return result;
        // write your code here
    }
}
