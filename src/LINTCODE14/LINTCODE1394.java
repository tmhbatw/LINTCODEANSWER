package LINTCODE14;

public class LINTCODE1394 {
    /*Description
    * 给定句子S，其由用空格分隔的单词组成。 每个单词仅包含小写和大写字母。
    * 我们想将句子转换为“Goat Latin”（一种类似于Pig Latin的伪造语言）。
    * Goat Latin的规则如下：
    * 如果一个单词以元音（a，e，i，o或u）开头，则在单词的末尾附加“ma”。
    * 例如，“apple”这个词就变成了“applema”。
    * 如果一个单词以辅音（即不是元音）开头，则删除第一个字母并追加它到最后，然后添加“ma”。
    * 例如，“山羊”这个词就变成了“oatgma”。
    * 在句子的每个单词的末尾添加一个字母'a'，从1开始。
    * 例如，第一个单词将“a”添加到结尾，第二个单词将“aa”添加到结尾，依此类推。
    * 返回将从S到Goat Latin的转换后的最终语句
    * */

    public String  toGoatLatin(String S) {
        if(S.length()==0)
            return "";
        StringBuilder res=new StringBuilder();
        String[] s=S.split(" ");
        for(int i=0;i<s.length;i++){
            String cur=s[i];
            switch(cur.charAt(0)){
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    break;
                default:
                    cur=cur.substring(1)+cur.charAt(0);
            }
            res.append(cur).append("ma");
            res.append(getPostfix(i));
            res.append(" ");
        }
        return res.toString().substring(0,res.length()-1);
        //
    }

    private String getPostfix(int time){
        StringBuilder res= new StringBuilder();
        for(int i=0;i<time+1;i++)
            res.append("a");
        return res.toString();
    }

}
