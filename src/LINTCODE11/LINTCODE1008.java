package LINTCODE11;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1008 {
    /*Description
    * 人们会用重复扩展的字母，来表达某种感情，例如hello->heeellooo，hi->hiiii。这里，我们有一组相邻的字母，
    * 它们都是相同的字符，组的相邻字符是不同的。如果一个组的长度为3或更多，则该组被扩展，因此在第一个示例中“e”和“o”将被扩展，
    * 而在第二个示例中“i”将被扩展。 规定“组”表示一串连续相同字母。例如abbcccaaaa的“组”包括a， bb，ccc，aaaa.
    * 给定字符串S，如果通过扩展一个单词能够得到S，则称该单词是S的“弹性词”。扩展时，可以向单词的某个“组”进行扩展，
    * 使该“组”的长度大于等于3. 不允许将h这样的组扩展到hh，因为长度只有2，所有扩展必须使“组”的长度大于等于3.
    * 给定一个单词列表words，返回S的弹性词数量。
    * */

    public int expressiveWords(String S, String[] words) {
        List<List<Integer>> s=parseS(S);
        int result=0;
        for(String word:words){
            List<List<Integer>> curList=parseS(word);
            if(curList.get(0).size()!=s.get(0).size())
                continue;
            boolean isMatch=true;
            for(int i=0;i<s.get(0).size();i++){
                if(!s.get(0).get(i).equals(curList.get(0).get(i))
                    ||s.get(1).get(i)<curList.get(1).get(i)
                    ||s.get(1).get(i)<3&&!s.get(1).get(i).equals(curList.get(1).get(i))) {
                    isMatch = false;
                    break;
                }
            }
            if(isMatch)
                result++;
        }
        return result;
        // write your code here
    }

    private List<List<Integer>> parseS(String s){
        List<Integer> list=new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        int length=s.length();
        for(int i=0;i<length;i++){
            char cur=s.charAt(i);
            int count=1;
            while(i<length-1&&s.charAt(i+1)==cur){
                count++;
                i++;
            }
            list.add(cur-'a');
            num.add(count);
        }
        List<List<Integer>> result=new ArrayList<>();
        result.add(list);
        result.add(num);
        return result;
    }
}
