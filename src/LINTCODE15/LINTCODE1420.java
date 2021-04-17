package LINTCODE15;

public class LINTCODE1420 {
    /*Description
    *给你一个字符串 S、一个字符串 T，S是循环的，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
    * */

    public String minWindowII(String S, String T) {
        int[] numS=new int[128];
        for(int i=0;i<S.length();i++)
            numS[S.charAt(i)]++;
        int[] numT=new int[128];
        for(int i=0;i<T.length();i++)
            numT[T.charAt(i)]++;
        if(getTime(numS,numT)==0)
            return "";
        int time=getTime(numS,numT);
        int sLength=S.length();
        String SS="";
        for(int i=0;i<=time;i++)
            SS+=S;
        S=SS;
        int min=Integer.MAX_VALUE;
        int start=0;
        int right=-1;
        numS=new int[128];
        for(int i=0;i<sLength;i++){
            while(!isMatch(numS,numT)){
                right++;
                numS[S.charAt(right)]++;
            }
            int curLength=right-i+1;
            if(curLength<min){
                min=curLength;
                start=i;
            }
            numS[S.charAt(i)]--;
        }
        return S.substring(start,start+min);
        // Write your code here
    }

    private int getTime(int[] numS,int[] numT){
        int time=1;
        for(int i=0;i<128;i++){
            if(numT[i]>0){
                if(numS[i]==0)
                    return 0;
                time=Math.max(time,(numT[i]-1)/numS[i]+1);
            }
        }
        return time;
    }

    private boolean isMatch(int[] numS,int[] numT){
        for(int i=0;i<128;i++){
            if(numS[i]<numT[i])
                return false;
        }
        return true;
    }
}
