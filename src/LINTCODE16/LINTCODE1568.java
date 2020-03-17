package LINTCODE16;

public class LINTCODE1568 {
    /*Description
    * 给定n瓶水，其中只有一瓶水是毒药， 小白鼠会在喝下任何剂量的毒药后24小时死亡。
    * 请问如果需要在24小时的时候知道那瓶水是毒药，那么至少需要几个小白鼠才能保证测试成功？
    * （也就是说只能给每只小白鼠喂一次水）
    * */

    public int getAns(int n) {
        int time=0;
        int number=1;
        while(number<n){
            time++;
            number*=2;
        }
        return time;
        // Write your code here
    }
}
