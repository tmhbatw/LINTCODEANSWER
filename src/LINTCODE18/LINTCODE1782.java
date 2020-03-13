package LINTCODE18;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1782 {
    /*Description
    * 你有一家专门经营没有相邻匹配字符的单词的精品店。鲍比，一个竞争对手，已经决定完全退出这个业务并且你买了他的库存，
    * 你的想法是修改他的词汇库存，使他们适合在你的商店出售。为此，你找到所有相邻的匹配字符对，并将其中一个字符替换为另一个字符对。
    * 确定必须替换的最小字符数，以生成一个畅销词。例如，你购买了 words = ["odd","boook","treak"]。在 "odd" 中更改 'd'，在 "boook" 中更改 'o'，
    * 在 "treak" 中不需要更改。返回数组 result = [1,1,0]。
    * 在下面的编辑器中完成函数的最小操作。函数必须返回一个整数数组，每个 result[i] 是修复 words[i] 所需的最小操作。
    * */

    public List<Integer> minimalOperation (List<String> words) {
        List<Integer> result=new ArrayList<>();
        for(String cur:words)
            result.add(getValue(cur));
        return result;
        // Write your code here.
    }

    private int getValue(String s){
        int result=0;
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            int time=1;
            while(i<s.length()-1&&s.charAt(i+1)==cur) {
                i++;
                time++;
            }
            result+=time/2;
        }
        return result;
    }
}
