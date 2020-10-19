package LINTCODE4;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE352 {
    /*Description
    * 给出文本 text ，其中有 nn 条句子，每个句子由数个单词组成（数量大于 0），以及一个宽度 width，
    * 请将句子进行美观打印在宽度为 width 的窗口内。打印的规则如下：
    * 两条句子不应该在同一行，即打印完一个句子后应该换行。
    * 每个句子中，单词应该从左往右顶格打印，两个单词之间用一个空格隔开。
    * 如果一行中右侧剩下的空格不足填入新的单词，那么换行，从头开始打印。
    * 每一行末尾要用空格填充，使其长度和 width 相等。
    * 打印结果要用一圈星号 '*' 包装，星号不计入宽度中。
    * */

    public List<String> prettyPrint(List<List<String>> text, int width) {
        List<String> result=new ArrayList<>();
        result.add(StarPrint(width));
        for(List<String> cur:text){
            result.addAll(getRes(cur,width));
        }
        result.add(StarPrint(width));
        return result;
        // write your code here
    }

    private List<String> getRes(List<String> cur, int width){
        List<String> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        sb.append(cur.get(0));
        for(int i=1;i<cur.size();i++){
            String curr=cur.get(i);
            if(sb.length()+1+curr.length()>width){
                int spaceLength=width-sb.length();
                while(spaceLength-->0){
                    sb.append(" ");
                }
                sb.insert(0,"*");
                sb.append("*");
                result.add(sb.toString());
                sb=new StringBuilder();
                sb.append(cur.get(i));
            }else
                sb.append(" ").append(curr);
        }
        int spaceLength=width-sb.length();
        while(spaceLength-->0)
            sb.append(" ");
        sb.insert(0,'*');
        sb.append('*');
        result.add(sb.toString());
        return result;
    }


    private String StarPrint(int width){
        width+=2;
        StringBuilder sb=new StringBuilder();
        while(width-->0){
            sb.append('*');
        }
        return sb.toString();
    }
}
