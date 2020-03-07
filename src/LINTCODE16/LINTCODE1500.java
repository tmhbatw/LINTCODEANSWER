package LINTCODE16;

public class LINTCODE1500 {

    public int binaryGap(int N) {
        int pre=-1;
        int result=0;
        int index=-1;
        while(N>0){
            index++;
            int cur=N%2;
            if(cur==1){
                if (pre != -1) {
                    result = Math.max(result, index - pre);
                }
                pre=index;
            }
            N/=2;
        }
        return result;
        // Write your code here.
    }
}
