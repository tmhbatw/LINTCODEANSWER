package LINTCODE3;

public class LINTCODE253 {
    /*Description
    * 给出一个只包含大小写英文字符的字符串，你需要打出这个字符串。
    * 一开始键盘的 Capslock 是关闭的，即小写状态，要求打出这个字符串后还是小写状态。
    * 你可以进行以下三种操作：
    * 输入一个字符，屏幕上将打印出一个相应大小写状态的字符。视为敲击 1 次键盘。
    * 按下 Capslock，切换键盘当前的大小写状态。视为敲击 1 次键盘。
    * 按下 Shift 加某个字符，屏幕上将打印出一个与当前大小写状态相反的字符。视为敲击 2 次键盘。例如小写状态上，Shift + 'p' 将会输出 ‘P’。
    * */

    public int minimumTyping(String str) {
        int length=str.length();
        int[] dp1=new int[length+1];
        int[] dp2=new int[length+1];
        dp2[0]=1;
        for(int i=0;i<length;i++){
            char cur=str.charAt(i);
            if(isCapital(cur)){
                dp2[i+1]=Math.min(dp2[i]+1,dp1[i]+2);
                dp1[i+1]=Math.min(dp1[i]+2,dp2[i]+2);
            }else{
                dp1[i+1]=Math.min(dp1[i]+1,dp2[i]+2);
                dp2[i+1]=Math.min(dp2[i]+2,dp1[i]+2);
            }
        }
        return Math.min(dp1[length],dp2[length]+1);
        // write your code.
    }

    private boolean isCapital(char cur){
        if(cur<='Z'&&cur>='A')
            return true;
        return false;
    }
}
