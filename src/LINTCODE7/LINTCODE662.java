package LINTCODE7;

public class LINTCODE662 {
    /*Description
    * 我们正在玩猜数游戏。 游戏如下：
    * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个号码。
    * 每次你猜错了，我会告诉你这个数字与你猜测的数字相比是大还是小。
    * 你调用一个预定义的接口 guess(int num)，它会返回 3 个可能的结果(-1，1或0):
    * -1代表这个数字小于你猜测的数
    * 1代表这个数字大于你猜测的数
    * 0代表这个数字等于你猜测的数
    * */
    int guess(int num){
        return 1;
    }

    public int guessNumber(int n) {
        int left=1,right=n;
        int mid;
        while(true){
            mid=left+(right-left)/2;
            if(guess(mid)==0)
                return mid;
            if(guess(mid)==-1){
                right=mid-1;
            }else
                left=mid+1;
        }
        // Write your code here
    }
}
