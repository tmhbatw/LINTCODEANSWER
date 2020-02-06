package LINTCODE13;

public class LINTCODE1228 {
    /*Description
    * 我们先考虑一下简单的版本。
    * 假设p==m,也即对于一只猪我们只有一次测试的机会，此时假设我们有两只猪，应最多能测得四个桶子的情况（给A猪喂1,3桶，B猪喂2,3桶，
    * 若只有A猪死亡则1桶有毒药，只有B猪死亡则2桶有毒药，A、B猪均死亡则3桶有毒药，若A、B猪都没事则4桶有毒药）
    * 同理,若三只猪用同样的方法可发现最多能测得8个桶子的情况。
    * 假设p==2∗m，即有两次测试情况，我们发现n只猪最多可以测试3的n次方的桶子。
    * 一般的，n只猪最多可以测试⌈p/m+1⌉。
    * */

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int time=minutesToTest/minutesToDie+1;
        int pig=0;
        int sum=1;
        while(sum<buckets){
            sum*=time;
            pig++;
        }
        return pig;
        // Write your code here
    }
}
