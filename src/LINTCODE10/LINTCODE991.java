package LINTCODE10;

public class LINTCODE991 {
    /*Description
    * 起初这 n 个灯泡都是关闭状态。首先你把所有灯泡都打开。
    * 然后，每隔一个灯泡关闭下一个灯泡。在第三回合，每隔两个灯泡转换下一个灯泡的状态（如果原先是关闭状态就打开，反之则关闭）。
    * 对于第 i回合，每隔i - 1 个灯泡，转换下一个灯泡的状态。对于第 n 回合，只需要转换最后一个灯泡的状态。在 n 回合之后，还有多少灯泡亮着。
    * */

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
        // Write your code here
    }
}
