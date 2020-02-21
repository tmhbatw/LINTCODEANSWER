package LINTCODE13;

public class LINTCODE1277 {
    /*Description
    * 你有两个罐子，容量分别为 x 和 y 公升。你可以获取到无限数量的水。你需要判断能否使用这两个罐子量出恰好 z 公升的水。
    * 如果 z 公升水可以量出，你必须在若干次操作后，可以在一个或两个罐子中盛上 z 公升的水。
    * 允许的操作：
    * 将任意一个罐子盛满水。
    * 倒空任意一个罐子里的水。
    * 将一个罐子中的水倒入另一个罐子，直到这个罐子完全空了或者另一个罐子满了。
    * */

    public boolean canMeasureWater(int x, int y, int z) {
        return z%getCommonDivisor(x,y)==0;
        // Write your code here
    }

    private int getCommonDivisor(int x,int y){
        int max=Math.max(x,y);
        int min=Math.min(x,y);
        while(max%min!=0){
            int time=max/min;
            max-=time*min;
            int temp=max;
            max=min;
            min=temp;

        }
        return min;
    }
}
