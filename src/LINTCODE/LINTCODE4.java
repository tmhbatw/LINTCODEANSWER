package LINTCODE;

public class LINTCODE4 {
    public static int nthUglyNumber(int n) {
        int[] result=new int[n];
        result[0]=1;
        int two=0,three=0,five=0;
        for(int i=1;i<n;i++){
            result[i]=Math.min(result[two]*2,Math.min(result[three]*3,result[five]*5));
            if(result[i]==result[two]*2)
                two++;
            if(result[i]==result[three]*3)
                three++;
            if(result[i]==result[five]*5)
                five++;
        }
        return result[n-1];
    }

    public static void main(String[] args){
        System.out.println(nthUglyNumber(1665));
    }
}
