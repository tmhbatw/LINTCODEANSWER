package LINTCODE19;

public class LINTCODE1887 {
    /*Description
    *如果同一字母连续出现两次以上，我们将其称为延伸单词，例如单词“helllooo”，除延伸单词之外的单词都称之为普通单词，
    * 我们可以通过删除连续的字母将延伸单词转换成普通单词，但至少保留一个字母。今天，我们希望您将延伸单词转换为普通单词，求您能得到的普通单词的数量。
    * */

    public long StretchWord(String S) {
        char[] s=S.toCharArray();
        int res=0;
        int length=s.length;
        for(int i=0;i<length;i++){
            char cur=s[i];
            int end=i;
            while(end<length-1&&s[end+1]==cur){
                end++;
            }
            if((end!=length-1)&&end-i>=1||end-i>=2)
                res++;
            i=end;
        }
        long result=1;
        for(int i=0;i<res;i++)
            result*=2;
        return result;
        // write your code here
    }
}
