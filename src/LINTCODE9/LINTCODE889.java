package LINTCODE9;

public class LINTCODE889 {
    /*Description
    * 给定一个行rows x cols屏幕和一个由非空单词列表表示的句子sentence，找出在屏幕上可以安装多少次给定的语句。
    * */

    private int result=0;
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int index=0;
        int wordLength=sentence.length;
        int[] length=new int[wordLength];
        for(int i=0;i<wordLength;i++) {
            length[i] = sentence[i].length();
            if(length[i]>cols)
                return result;
        }
        for(int i=0;i<rows;i++){
            int curCols=cols-length[index];
            index=getNextIndex(index,wordLength);
            while(curCols>0&&length[index]+1<=curCols){
                curCols-=length[index]+1;
                index=getNextIndex(index,wordLength);
            }
        }
        return result;
        // Write your code here
    }
    private int getNextIndex(int cur,int length){
        cur++;
        if(cur==length) {
            result++;
            return 0;
        }
        return cur;
    }
}
