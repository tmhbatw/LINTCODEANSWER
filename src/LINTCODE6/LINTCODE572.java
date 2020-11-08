package LINTCODE6;

public class LINTCODE572 {
    /*Description
    * 给定一些音乐的时长，我们想从中选两个不同的歌曲，使得他们的总时长是60的倍数，请计算我们有多少种选法。
    * */

    public long musicPairs(int[] musics) {
        int[] num=new int[60];
        for(int cur:musics){
            num[cur%60]++;
        }
        long result=0;
        result+=getRes(num[0]);
        result+=getRes(num[30]);
        for(int i=1;i<30;i++){
            result += num[i] * num[60 - i];
        }
        return result;
        // write your code here
    }

    private long getRes(int cur){
        return (long)cur*(cur-1)/2;
    }

    public static void main(String[] args){
        double a=10.1;
        double b=10.2;
        System.out.println(a+b);
        System.out.println((int)a+b);
    }
}
