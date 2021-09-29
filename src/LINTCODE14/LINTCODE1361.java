package LINTCODE14;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1361 {
    /*Description
    * 给定一个单词数组和一个宽度maxWidth，格式化文本，使每行具有刚好maxWidth个字符并完全（左和右）对齐。
    *
    * 你应该用贪心法打包你的单词; 也就是说，在每行中包含尽可能多的单词。 必要时填充额外的空格，以便每行具有正确的maxWidth字符。
    *
    * 单词之间的额外空格应尽可能均匀分布。 如果一行上的空格数不均匀分配，则左侧的空插槽将分配比右侧插槽更多的空格。
    *
    * 对于最后一行文本，它应该是左对齐的，并且在单词之间不插入额外的空格。
    * */

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<>();
        int length=words.length;
        for(int i=0;i<length;i++){
            int curLength=words[i].length();
            int start=i;
            while(i<length-1&&curLength+1+words[i+1].length()<=maxWidth)
                curLength+=1+words[++i].length();
            result.add(getRes(words,start,i,maxWidth,i==length-1));
        }
        return result;
        // write your code here
    }

    private String getRes(String[] words,int start,int end,int maxWidth,boolean isLast){
        if(start==end){
            return words[start]+getSpace(maxWidth-words[start].length());
        }
        StringBuilder res=new StringBuilder();
        if(isLast){
            for(int i=start;i<end;i++){
                res.append(words[i]).append(" ");
            }
            res.append(words[end]);
            res.append(getSpace(maxWidth-res.length()));

            return res.toString();
        }
        int length=0;
        for(int i=start;i<=end;i++)
            length+=words[i].length();
        int spaceTime=(maxWidth-length)/(end-start);
        int bigTime=(maxWidth-length)-(end-start)*spaceTime;
        for(int i=start;i<end;i++){
            res.append(words[i]);
            if(bigTime>0){
                bigTime--;
                res.append(getSpace(spaceTime+1));
            }else
                res.append(getSpace(spaceTime));
        }
        res.append(words[end]);
        return res.toString();
    }

    private String getSpace(int num){
        StringBuilder sb=new StringBuilder();
        while(num-->0)
            sb.append(" ");
        return sb.toString();
    }
}
