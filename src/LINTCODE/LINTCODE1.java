package LINTCODE;

public class LINTCODE1 {
    public static  int aplusb(int a, int b) {
        while((a&b)<<1!=0){
            int temp=a^b;
            b=(a&b)<<1;
            a=temp;
        }
        return a^b;
    }
    public static void main(String[] args){
        System.out.println(aplusb(3,6));
    }
}
