package LINTCODE9;

public class LINTCODE812 {
    /*Description
    * 给定一组关键字“words”和一个字符串“S”，将所有关键字以S粗体显示。<b> 和 </b>标记之间的任何字母都将加粗。
    * 返回的字符串应该使用尽可能少的标签，当然这些标签应该组成一个有效的组合。
    * */

    /*Solution
    * 用一个数组用来存储是否是粗体
    * */

    public String boldWords(String[] words, String S) {
        boolean[] bold=new boolean[S.length()];
        for(String cur:words)
            finishBold(S,cur,bold);
        boolean curIndex=false;
        StringBuilder res= new StringBuilder();
        for(int i=0;i<bold.length;i++){
            if(!curIndex&&bold[i]){
                res.append("<b>");
                curIndex=true;
            }else if(curIndex&&!bold[i]){
                curIndex=false;
                res.append("</b>");
            }
            res.append(S.charAt(i));
        }
        if(curIndex)
            res.append("</b>");
        return res.toString();
        // Write your code here
    }

    private void finishBold(String s,String curWords,boolean[] bold){
        int index=s.indexOf(curWords);
        while(index!=-1){
            for(int i=0;i<curWords.length();i++)
                bold[index+i]=true;
            index=s.indexOf(curWords,index+1);
        }
    }
}
