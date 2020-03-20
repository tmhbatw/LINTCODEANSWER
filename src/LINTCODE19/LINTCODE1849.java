package LINTCODE19;

public class LINTCODE1849 {
    /*Description
    * 有一个书店，在接下来的nn天中的第ii天会有customer[i]customer[i]个顾客到来，并且在这一天结束后离开。
    * 但是书店老板的脾气时好时坏，我们用一个数组grumpygrumpy表示他每一天的脾气好坏，若grumpy[i]=1grumpy[i]=1, 则表示第ii天老板的脾气很不好；若grumpy[i]=0grumpy[i]=0, 则表示第ii天老板的脾气很好。
    * 若某一天书店老板的脾气不好，则会导致所有当天来的所有顾客会给书店差评。但如果某一天脾气好，那么当天所有顾客都会给书店好评。
    * 老板想要尽量增加给书店好评的人数数量，想了一个方法。他可以保持连续XX天的好脾气。但这个方法只能使用一次。
    * 那么在这nn天这个书店最多能有多少人离开时给书店好评？
    * */

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result=0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]==0){
                result+=customers[i];
                customers[i]=0;
            }
        }
        int curSum=0;
        int max=0;
        for(int i=0;i<X-1;i++)
            curSum+=customers[i];
        for(int i=X-1;i<grumpy.length;i++){
            curSum+=customers[i];
            max=Math.max(max,curSum);
            curSum-=customers[i-X+1];
        }
        return result+max;
        // write your code here
    }
}
