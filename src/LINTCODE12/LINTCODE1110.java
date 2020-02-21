package LINTCODE12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE1110 {
    /*Description
    * 在英语中，我们有一个名为词根（root）的概念，可以接其他一些词来形成另一个更长的词 - 让我们称这个词为后继词。 例如，词根a，后面接上其他词，可以形成另一个词。
    * 现在，给出一个由许多词根和一个句子组成的字典。 你需要用形成它的词根替换句子中的所有后继词。 如果后继次有许多根可以形成它，则用最短长度的词根替换它。
    * 替换后输出完整的句子。
    * */

    public String replaceWords(List<String> dict, String sentence) {
        String[] s=sentence.split(" ");
        Set<String> set=new HashSet<>(dict);
        StringBuilder sb=new StringBuilder();
        for(String cur:s){
            for(int i=0;i<cur.length();i++){
                String curr=cur.substring(0,i+1);
                if(set.contains(curr)||i==cur.length()-1){
                    sb.append(curr).append(" ");
                    break;
                }
            }
        }
        return sb.substring(0,sb.length()-1).toString();
        // write your code here
    }
}
