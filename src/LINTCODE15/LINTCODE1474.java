package LINTCODE15;

public class LINTCODE1474 {
    /*Description
    * 我们规定，在一篇文章中，一个短语由至少k个连续的单词组成，并且其总长度不小于lim。
    * 现在我们将一篇文章以一个字符串数组str的形式给出，要求输出这篇文章中最短的短语长度。
    * */

    public int getLength(int k, int lim, String[] str) {
        int length=str.length;
        int[] time=new int[length];
        for(int i=0;i<length;i++)
            time[i]=str[i].length();
        int result=-1;
        int end=0;
        int curSum=0;
        for(int i=0;i<length;i++){
            curSum+=time[i];
            while(end-i<k||curSum<lim){
                if(end==length-1)
                    return result;
                curSum+=time[end++];
            }
            if(end-i+1>=k&&curSum>=lim){
                result=result==-1?curSum:Math.min(result,curSum);
            }
            curSum-=time[i];
        }
        return result;
        // Write your code here
    }
}
